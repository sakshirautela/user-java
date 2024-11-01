public class DeleteCharacterstoMakeFancyString {
    public static String makeFancyString(String s) {
        int n = s.length();
        String str = "";
        for (int i = 0; i < n; i++) {
            if (i + 2 < n && s.charAt(i + 2) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            }
            str += s.charAt(i);
        }
        return str;
    }

    public String makeFancyString2(String s) {
        // If the size of the string is less than 3, return it.
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        // Start by appending the first two characters to StringBuilder.
        sb.append(s.charAt(0)).append(s.charAt(1));

        // Iterate from the 3rd character onwards.
        for (int i = 2; i < s.length(); ++i) {
            // If the current character is not equal to the previously inserted
            // two characters, then we can add it to the StringBuilder.
            if (s.charAt(i) != sb.charAt(sb.length() - 1) ||
                    s.charAt(i) != sb.charAt(sb.length() - 2)) {
                sb.append(s.charAt(i));
            }
        }

        // Convert StringBuilder back to String and return.
        return sb.toString();
    }

    public String makeFancyString3(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            } else {
                sameCount = 1;
            }
            if (sameCount < 3)
                sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
