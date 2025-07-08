public class FindtheOriginalTypedStringI {
    public static void main(String[] args) {
        System.out.println(possibleStringCount(""));
    }

    public static int possibleStringCount(String word) {
        int n = word.length();
        int result = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                result += count;
                count = 0;
            }
        }
        if (count > 0) {
            result += count;
        }
        return result;
    }

    public int possibleStringCountFast(String word) {
        // abcccc
        // abbcc
        // abbc
        // abbccc
        // abbcccc
        int ans = 0;
        char prevChar = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == prevChar) {
                ans++;
            } else {
                prevChar = c;
            }
        }
        return ans + 1;

    }
}