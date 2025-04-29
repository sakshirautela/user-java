
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca")); // Output should be 2
    }

    public static int countPalindromicSubsequence(String s) {
        if (s.length() < 3) {
            return 0; // No palindromic subsequences of length 3
        }

        int[] first = new int[26];  // Stores the first occurrence index of each character
        int[] last = new int[26];   // Stores the last occurrence index of each character
        Arrays.fill(first, -1);

        // Fill the first and last occurrence arrays
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (first[curr] == -1) {
                first[curr] = i;
            }
            last[curr] = i;
        }

        int ans = 0;

        // Now, calculate the number of unique palindromic subsequences
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue; // If the character doesn't appear, skip it
            }

            Set<Character> between = new HashSet<>(); // To store unique characters between first and last occurrence of i
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));  // Add characters between first and last occurrence
            }

            ans += between.size(); // Count of unique characters between first and last occurrence of character i
        }

        return ans;  // Return the count of unique palindromic subsequences
    }
}
