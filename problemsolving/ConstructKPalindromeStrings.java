
public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        System.out.println(canConstruct("", 5));
    }

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        } else if (s.length() == k) {
            return true;
        }
        int[] freq = new int[26];
        int odd = 0;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i : freq) {
            if (i % 2 == 1)
                odd++;
        }
        return odd <= k;
    }

    public boolean canConstruct2(String s, int k) {
        // Handle edge cases
        if (s.length() < k)
            return false;
        if (s.length() == k)
            return true;

        // Initialize oddCount as an integer bitmask
        int oddCount = 0;

        // Update the bitmask for each character in the string
        for (char chr : s.toCharArray()) {
            oddCount ^= 1 << (chr - 'a');
        }

        // Return if the number of odd frequencies is less than or equal to k
        return Integer.bitCount(oddCount) <= k;
    }
}
