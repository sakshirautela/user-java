
import java.util.Arrays;

public class SumofPrefixScoresofStrings {
    public static int[] sumPrefixScores(String[] words) {
        int n=words.length;
        int[] result=new int[n];
        for (String i : words) {
            insertInTrie(i);
        }
        for (int i = 0; i < n; i++) {
            result[i]=searchInTrie(words[i]);
        }
        return result;
    }
    static class Node{
        Node[] digit;
        int count;
        public Node(){
            digit=new Node[26];
            count=0;
        }
    }
    static Node node=new Node();
    private static void insertInTrie(String s) {
        Node curr=node;
        for (int j = 0; j < s.length(); j++) {
            int idx=s.charAt(j)-'a';
            if(curr.digit[idx]==null){
                curr.digit[idx]=new Node();
                curr.digit[idx].count++;
                curr=curr.digit[idx];
            }else{
                curr.digit[idx].count++;
                curr =curr.digit[idx];
            }
        }
    }
    private static int  searchInTrie(String s) {
        Node curr=node;
        int ans = 0;
        // The ans would store the total sum of counts.
        for (char c : s.toCharArray()) {
            ans += curr.digit[c - 'a'].count;
            curr = curr.digit[c - 'a'];
        }
        return ans;
    }

    //second ans
    public int[] sumPrefixScores2(String[] words) {
        int wordCount = words.length;
        Integer[] sortedIndices = new Integer[wordCount];
        for (int i = 0; i < wordCount; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, (a, b) -> words[a].compareTo(words[b]));
        
        int[] commonPrefixLengths = calculateCommonPrefixLengths2(words, sortedIndices);
        int[] scores = calculateScores(words, sortedIndices, commonPrefixLengths);
        return scores;
    }

    private int[] calculateCommonPrefixLengths2(String[] words, Integer[] sortedIndices) {
        int[] commonPrefixLengths = new int[words.length];
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[sortedIndices[i - 1]];
            String currWord = words[sortedIndices[i]];
            int commonLength = 0;
            while (commonLength < prevWord.length() && 
                   commonLength < currWord.length() && 
                   prevWord.charAt(commonLength) == currWord.charAt(commonLength)) {
                commonLength++;
            }
            commonPrefixLengths[i] = commonLength;
        }
        return commonPrefixLengths;
    }

    private int[] calculateScores(String[] words, Integer[] sortedIndices, int[] commonPrefixLengths) {
        int[] scores = new int[words.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            int wordIndex = sortedIndices[i];
            int wordLength = words[wordIndex].length();
            scores[wordIndex] += wordLength;
            int j = i + 1;
            int commonLength = wordLength;
            while (j < words.length) {
                commonLength = Math.min(commonLength, commonPrefixLengths[j]);
                if (commonLength == 0) {
                    break;
                }
                scores[wordIndex] += commonLength;
                scores[sortedIndices[j]] += commonLength;
                j++;
            }
        }
        return scores;
    }
//Kds Appraoch 1
    public static void main(String rags[]){
        int[] result=sumPrefixScores(new String[]{"abcd"});
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}
