package problemsolvingIII;

public class CountDerangements {
    static void main() {
        System.out.println(derangeCount(4));
    }

    public static int derangeCount(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        int result = 0;
        int first = 0;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            result=(i-1)*(first+second);
            first=second;
            second=result;
        }
        return result;
    }
};