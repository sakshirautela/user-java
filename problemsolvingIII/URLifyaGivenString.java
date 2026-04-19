package problemsolvingIII;

public class URLifyaGivenString {
    static void main() {
        System.out.println(URLify(""));
    }

    static String URLify(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}