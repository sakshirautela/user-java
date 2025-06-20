import java.util.ArrayList;

public class AllPalindromicPartitions {
    public static void main(String[] args) {
        System.out.println(palinParts("geeks"));
    }
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
        int n=s.length();
        palinPartsUtil(res,new ArrayList<String>(),0,n,s);
        return res;
    }
    private static void palinPartsUtil(ArrayList<ArrayList<String>> res, ArrayList<String> sub,int i, int n, String string) {
        if(i==n){
            res.add(new ArrayList<String>(sub));
        }
        for (int j = i+1; j <= n; j++) {
            if(isPlaindrome(string.substring(i,j))){
                sub.add(string.substring(i,j));
                palinPartsUtil(res,sub,j,n,string);
                sub.remove(sub.size()-1);
            }
        }
    }
    private static boolean isPlaindrome(String substring) {
        int i=0,j=substring.length()-1;
        while (i<j) {
            if(substring.charAt(i)!=substring.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
