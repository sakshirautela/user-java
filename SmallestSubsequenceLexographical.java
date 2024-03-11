import java.util.*;
public class SmallestSubsequenceLexographical {
    public static String smallestSubsequence(String s) {
        int[] lastoccur=new int[26];
        Stack<Character> st = new Stack<>();
        boolean visited[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            lastoccur[ch-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(visited[ch-'a'])
                continue;
            while(!st.isEmpty() && ch<st.peek() && lastoccur[st.peek()-'a']>i){
                visited[st.pop()-'a']=false;
            }
            st.push(ch);
            visited[ch-'a']=true;
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(smallestSubsequence("cbaacabcaaccaacababa"));
    }
}