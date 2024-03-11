import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        int count1[] =new int[26];
        int count2[] = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            count1[word1.charAt(i)-'a'] = count1[word1.charAt(i) - 'a']+1;
            count2[word2.charAt(i) - 'a'] = count2[word2.charAt(i) - 'a']+1;
        }
        for (int i = 0; i < count1.length;i++){
            if((count1[i]!=0 && count2[i]==0) || (count2[i] != 0 && count1[i] == 0)){
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        
        return count1.equals(count2);

    }
    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "aabbss"));
    }
}