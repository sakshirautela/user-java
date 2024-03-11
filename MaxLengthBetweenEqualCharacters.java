import java.util.*;
public class MaxLengthBetweenEqualCharacters {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int idx[]=new int[26];
        int res=-1;
        Arrays.fill(idx,-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(idx[ch-'a']!=-1){
                res=Math.max(res,i-idx[ch-'a']-1);
            }else{
                idx[ch-'a']=i;
            }
        }
        for (int i = 0; i < idx.length; i++) {
            System.out.print(idx[i]+" ");
        }
        return res;
    }
    public static int maxLengthBetweenEqualCharacters2(String s) {
        int res=-1;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    res=Math.max(res,j-i-1);
                }
            }
        }
        return res;
    }
    public static int maxLengthBetweenEqualCharacters3(String s) {
        for(int i=s.length()-1;i>0;i--){
            for(int j=0;j+i<s.length();j++){
                if(s.charAt(j)==s.charAt(j+i)){
                    return i-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters3("abca"));
    }
}