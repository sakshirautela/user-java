import java.util.Arrays;

public class MaxLengthUniqueCharacters {
    public static int maxLength(String[] arr) {
        if(arr.length<=1){
            return arr.length;
        }
        return recursionCount(arr, 0, "");
    }
    private static int recursionCount(String[] arr, int i, String string) {
        if(i>=arr.length){
            if(uniqueCharactercontains(string+arr[i])){
                return string.length();
            }
            return 0;
        }
        int take =recursionCount(arr, i, string+arr[i]);
        int notake = recursionCount(arr, i,string);
        return Math.max(take,notake);
    }
    private static boolean uniqueCharactercontains(String string) {
        if(string.length()>26){
            return false;
        }
        int count[]=new int[26];
        for(char c : string.toCharArray()){
            count[c-'a']=count[c-'a']+1;
            if(count[c-'a']>1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(maxLength(new String[]{ "un", "iq", "ue"}));
    }
}