public class MinimumNumberofChangestoMakeBinaryStringBeautiful {
    public static int minChanges(String s) {
        // Initialize with first character of string
        char currentChar = s.charAt(0);
        int consecutiveCount = 0;
        int minChangesRequired = 0;
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If current character matches the previous sequence
            if (s.charAt(i) == currentChar) {
                consecutiveCount++;
                continue;
            }
            // If we have even count of characters, start new sequence
            if (consecutiveCount % 2 == 0) {
                consecutiveCount = 1;
            }
            // If odd count, we need to change current character
            // to match previous sequence
            else {
                consecutiveCount = 0;
                minChangesRequired++;
            }
            // Update current character for next iteration
            currentChar = s.charAt(i);
        }
        return minChangesRequired;
    }

    public static void main(String args[]) {
        System.out.print(minChanges(""));
    }

    public int minChanges2(String s) {
        int ans = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += s.charAt(i) - '0';
            if (i % 2 == 1) {
                ans += (c % 2);
                c = 0;
            }
        }
        return ans;
    }
}
