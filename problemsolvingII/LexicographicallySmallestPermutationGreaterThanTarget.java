import java.util.Arrays;

public class LexicographicallySmallestPermutationGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(lexGreaterPermutation("a","v"));
    }
    public static String lexGreaterPermutation(String s, String target) {
        String sb= "";
        char[] c=s.toCharArray();
        Arrays.sort(c);
        int n=s.length();
        boolean[] added=new boolean[n];
        lexGreaterPermutationUtil(c,n,0,target,added,sb);
        return sb;
    }

    private static void lexGreaterPermutationUtil(char[] c, int n, int i, String target, boolean[] added, String sb) {

    }
}
//        for (char ch:target.toCharArray()) {
//            int i=0;
//            while (i<n && (ch>c[i] || added[i])){
//                i++;
//            }
//            if(i<n ){
//                    if( ch<c[i]){
//                added[i]=true;
//                sb.append(c[i]);
//                break;
//            }else{
//                sb.append(c[i]);
//                added[i]=true;
//            }}
//        }
//        for (int i = 0; i <n ; i++) {
//            if(!added[i]){
//                sb.append(c[i]);
//            }
//        }
//        if(sb.toString().compareTo(target)<=0){
//            return "";
//        }

