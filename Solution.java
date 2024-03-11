import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner obj=new Scanner(System.in);
        int a=obj.nextInt();
        int b = obj.nextInt();
        int n=obj.nextInt();
        int result,r;
        for(int i=0;i<n;i++){
            result=(int)Math.pow(2, i);
            r=a+(b*result);
            System.out.print(" "+r);
        }
    }
}
