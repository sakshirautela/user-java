public class FindtheLengthoftheLongestCommonPrefix {
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        if(arr1.length==0 || arr2.length==0){
            return 0;
        }
        for (int i = 0; i < arr1.length; i++) {
            insertInTrie(arr1[i]);
        }
        int max=0;
        for (int i = 0; i < arr2.length; i++) {
            max=Math.max(max, searchInTrie(arr2[i]));
        }
        return max;
    }
    static class Node{
        Node[] digit;
        public Node(){
            digit=new Node[10];
        }
    }
    static Node node=new Node();
    private static void insertInTrie(int i) {
        String s=Integer.toString(i);
        Node curr=node;
        for (int j = 0; j < s.length(); j++) {
            int idx=s.charAt(j)-'0';
            if(curr.digit[idx]==null){
                curr.digit[idx]=new Node();
                curr=curr.digit[idx];
            }else{
                curr =curr.digit[idx];
            }
        }
    }
    private static int  searchInTrie(int i) {
        String s=Integer.toString(i);
        int max=0;
        Node curr=node;
        for (int j = 0; j < s.length(); j++) {
            int idx=s.charAt(j)-'0';
            if(curr.digit[idx]==null){
                return max;
            }else{
                curr =curr.digit[idx];
                max++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{5}, new int[]{33}));
    }
}
// class TrieNode {

//     // Each node has up to 10 possible children (digits 0-9)
//     TrieNode[] children = new TrieNode[10];
// }

// class Trie {

//     TrieNode root = new TrieNode();

//     // Insert a number into the Trie by treating it as a string of digits
//     void insert(int num) {
//         TrieNode node = root;
//         String numStr = Integer.toString(num);
//         for (char digit : numStr.toCharArray()) {
//             int idx = digit - '0';
//             if (node.children[idx] == null) {
//                 node.children[idx] = new TrieNode();
//             }
//             node = node.children[idx];
//         }
//     }

//     // Find the longest common prefix for a number in arr2 with the Trie
//     int findLongestPrefix(int num) {
//         TrieNode node = root;
//         String numStr = Integer.toString(num);
//         int len = 0;

//         for (char digit : numStr.toCharArray()) {
//             int idx = digit - '0';
//             if (node.children[idx] != null) {
//                 // Increase length if the current digit matches
//                 len++;
//                 node = node.children[idx];
//             } else {
//                 // Stop if no match for the current digit
//                 break;
//             }
//         }
//         return len;
//     }
// }

// class Solution {

//     public int longestCommonPrefix(int[] arr1, int[] arr2) {
//         Trie trie = new Trie();

//         // Step 1: Insert all numbers from arr1 into the Trie
//         for (int num : arr1) {
//             trie.insert(num);
//         }

//         int longestPrefix = 0;

//         // Step 2: Find the longest prefix match for each number in arr2
//         for (int num : arr2) {
//             int len = trie.findLongestPrefix(num);
//             longestPrefix = Math.max(longestPrefix, len);
//         }

//         return longestPrefix;
//     }
// }