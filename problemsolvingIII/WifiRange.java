package problemsolvingIII;

public class WifiRange {
    static void main() {
        System.out.println(wifiRange("", 2));
    }

    public static boolean wifiRange(String s, int x) {
        // code here
        int cover = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (cover < (i - x + 1)) {
                    return false;
                }
            }
            cover = Math.max(cover, x + i);
        }
        return cover >= s.length() - 1;
    }
}