package problemsolvingIII;

import java.util.ArrayList;

public class EqualPointinBrackets {
    static void main() {
        System.out.println(findIndex("((()(("));
    }
    public static int findIndex(String s) {
        // code here
        int n = s.length();
        int open=0;
        int close=0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                close++;
            }
        }
        for (int i = 0;i<n;i++) {
            if(open==close){
                return i;
            }
            if (s.charAt(i) == ')') {
                close--;
            }else{
                open++;
            }
        }
        if(open==close){
            return n;
        }
        return -1;
    }
}