public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("1e"));
    }

    public static boolean isNumber(String s) {
        if ((s.charAt(0) == 'e') || s.equals('.') || s.equals('-') || s.equals('+')) {
            return false;
        }
        int n = s.length();
        boolean isE = false;
        boolean pos = s.charAt(0) == '+';
        boolean isdec = false;
        int start = 0;
        while (s.charAt(start) == '-' || s.charAt(start) == '+') {
            start++;
        }
        if (start > 1) {
            return false;
        }
        boolean neg = s.charAt(0) == '-';
        for (int i = start; i < n; i++) {
            if (!isE && !isdec && s.charAt(i) == '.') {
                isdec = true;
            } else if (!isE && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                isE = true;
                i++;
                if (i < n && (s.charAt(i) == '.' || s.charAt(i) == '-' || s.charAt(i) == '+')) {
                    return false;
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
