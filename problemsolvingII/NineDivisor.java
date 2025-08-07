public class NineDivisor {
    public static void main(String[] args) {
        System.out.println(countNumbers(100));
    }
    public static int countNumbers(int n) {
        // code here
        int result = 0;
        for(int i=1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            if(count == 9) {
                result++;
            }
        }
        return result;
    }
}