
public class FinalValueAfterPerformingOperations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[] { "--X", "X++", "X++" }));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            if (s.charAt(0) == '-' || s.charAt(s.length() - 1) == '-') {
                x -= 1;
            } else {
                x++;
            }
        }
        return x;
    }

    public int finalValueAfterOperations2(String[] ops) {
        int n = 0;
        for (String s : ops) {
            if (s.charAt(1) == '+')
                n++;
            else
                n--;
        }
        return n;
    }
}
