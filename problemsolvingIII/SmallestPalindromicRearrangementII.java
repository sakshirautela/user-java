package problemsolvingIII;

public class SmallestPalindromicRearrangementII {
    static void main() {
        System.out.println(smallestPalindrome("bacab", 1));
    }

    public static String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        return "";
    }
}
