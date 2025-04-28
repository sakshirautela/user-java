package com.learn.java.problemsolving;

public class FindtheKthCharacterinStringGameI {
    public static char kthCharacter(int k) {
        String str="a";
        while(str.length()<k){
            String t="";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='z'){
                    t+='a';
                }else{
                    t+=((char)(str.charAt(i)+1));
                }
            }
            str+=t;
        }
        return str.charAt(k-1);
    }
    public static void main(String args[]){
        System.out.println(kthCharacter(5));
    }
}