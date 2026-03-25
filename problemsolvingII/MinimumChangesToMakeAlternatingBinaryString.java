public class MinimumChangesToMakeAlternatingBinaryString {
    static void main() {
        System.out.println(minOperations("0100"));
    }

    public static int minOperations(String s) {
        int n = s.length();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                s1 = s1 + '0';
                s2 = s2 + "1";
            }else{
                s1 = s1 + '1';
                s2 = s2 + "0";
            }

        }
        int a1 = 0;
        int a2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s2.charAt(i)) {
                a2++;
            }
            if (s.charAt(i) != s1.charAt(i)) {
                a1++;
            }
        }
        return Math.min(a1, a2);
    }
}
