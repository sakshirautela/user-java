package problemsolvingIII;

public class SmallestWindowContaining01and2 {
    static void main() {
        System.out.println(smallestSubstring("022001"));
    }

    public static int smallestSubstring(String s) {
        // code here
        int n=s.length();
        int[] all=new int[3];
        int result=n+1;
        int i=0,j=0;
        while (j<n){
            all[s.charAt(j++)-'0']++;
            while (i<n && all[0]>0 && all[1]>0  && all[2]>0 ){
                result=Math.min(result,j-i);
                all[s.charAt(i)-'0']--;
                i++;
            }
        }
        return result==n+1?-1:result;
    }
}