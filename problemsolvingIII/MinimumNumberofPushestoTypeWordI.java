package problemsolvingIII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class MinimumNumberofPushestoTypeWordI {
    static void main() {
        System.out.println(minimumPushes("hiknogatpyjzcdbe"));
    }
        public static int minimumPushes(String word) {
        int[] freq=new int[26];
           int result=0;
           for(char ch:word.toCharArray()){
               freq[ch-'a']++;
           }
           Arrays.sort(freq);
           int len=0;
           int c=1;
            for(int i=25;i>=0;i--){
                System.out.println(freq[i]);
                if(freq[i]>0){
                    result+=(c*freq[i]);
                    len++;
                    if(len%7==0){
                        len=1;
                        c++;
                    }
                }else{
                    break;
                }
            }
           return result;
        }
}
