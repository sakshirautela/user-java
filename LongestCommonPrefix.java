import java.util.Arrays;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start=strs[0];
        StringBuilder res=new StringBuilder();
        String end=strs[strs.length - 1];
        for(int i=0;i<Math.min(start.length(),end.length());i++){
            if(start.charAt(i)!=end.charAt(i)){
                return res.toString();
            }
            res.append(start.charAt(i));
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flight","flow"}));
    }
}