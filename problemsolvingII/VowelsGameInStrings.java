public class VowelsGameInStrings {
    public static void main(String[] args) {
        System.out.println(doesAliceWin(""));
    }

    public static boolean doesAliceWin(String s) {
        int n = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }
        return false;
    }
}
