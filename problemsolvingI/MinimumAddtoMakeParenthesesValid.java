
public class MinimumAddtoMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int open = 0;
        int add = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }
        return Math.abs(open + add);
    }

    public static void main(String args[]) {
        System.out.println(minAddToMakeValid(""));
    }
}
