import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {
    public static void main(String[] args) {
        System.out.println(getLongestSubsequence(new String[]{},new int[]{}));
    }
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> li=new ArrayList<>();
        int flip=groups[0];
        int n=words.length;
        li.add(words[0]);
        for(int i=1;i<n;i++){
            if(flip==1 && groups[i]==0){
                li.add(words[i]);
                flip=0;
            }else if(flip==0 && groups[i]==1){
                li.add(words[i]);
                flip=1;
            }
        }
        return li;
    }
    public List<String> getLongestSubsequence2(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int prev = -1;

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != prev) {
                prev = groups[i];
                result.add(words[i]);
            }
        }

        return result;
    }
}