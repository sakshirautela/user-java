package com.learn.java.problemsolving;

public class AddBinaryString {
    public static String addBinary(String s1, String s2) {
            // code here
            String res = "";
            int carry = 0;
            int i = s1.length() - 1;
            int j = s2.length()-1;
            while (i >= 0 || j >= 0) {
                int d1=(i>=0 && s1.charAt(i)=='1')?1:0;
                int d2=(j>=0 && s2.charAt(j)=='1')?1:0;
                char digit=((d1+d2+carry)%2==0)?'0':'1';
                carry=(d1+d2+carry)/2;
                res=digit+res;
                i--;
                j--;
            }
            if(carry==1){
                res='1'+res;
            }
            int idx=res.indexOf('1');
            return res.substring(idx);
        }
    
        public static void main(String[] args) {
            System.out.println(addBinary("1101","111"));
    }
}