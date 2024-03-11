public class intPermutation {
        public static  String getPermutation(int n, int k) {
            String a=str(n);
            return permute(a, "", k);
            

        }
        public static String str(int n){
            String a = "";
            for (int i = 1; i <= n; i++) {
                a = a + Integer.toString(i);
            }
            return a;
        }
        
        public static String permute(String str, String ans,int k) {
            if (k==0) {
                return ans;
            }
            for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                String newStr = str.substring(0, i) + str.substring(i + 1);
                permute(newStr, ans + curr,k-1);
            }
            return "";
        }
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 4));
    }
}
