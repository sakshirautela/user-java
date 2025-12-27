public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber(".1"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        boolean digit = false;
        boolean digitAfterE = true;
        boolean dot = false;
        boolean exp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;
                if (exp) digitAfterE = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !digit) return false;
                exp = true;
                digitAfterE = false;
            } else return false;
        }

        return digit && digitAfterE;
    }
}
