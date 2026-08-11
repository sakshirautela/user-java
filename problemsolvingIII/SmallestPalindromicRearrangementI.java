package problemsolvingIII;

public class SmallestPalindromicRearrangementI {
    static void main() {
        System.out.println(smallestPalindrome(""));
    }

    public static String smallestPalindromeII(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char middleChar = '.';
        StringBuilder a= new StringBuilder();
        for(int i=0;i<26;i++){
            while (freq[i]>=2){
                a.append((char)(i+'a'));
                freq[i]-=2;
            }
            if(freq[i]==1){
                middleChar= (char) (i+'a');
            }
        }
        StringBuilder b= new StringBuilder(a);
        b.reverse();
        if(middleChar!='.'){
            a.append(middleChar);
        }
         a.append(b);
        return a.toString();
    }
        public static String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        char middleChar = 0;

        // Count how many characters have odd frequency
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }

        // More than 1 odd-count letter → can't form palindrome
        if (oddCount > 1) return "";

        StringBuilder firstHalf = new StringBuilder();

        // Build first half of the palindrome
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                middleChar = (char) (i + 'a');
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char) (i + 'a'));
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();

        // Construct final palindrome
        return oddCount == 1
                ? firstHalf.toString() + middleChar + secondHalf.toString()
                : firstHalf.toString() + secondHalf.toString();
    }
}
