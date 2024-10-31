public class CountOfSubstringsContainingEveryVowelAndKConsonants {

    public static int countOfSubstrings(String word, int k) {
        int res = 0;

        // Outer loop for starting point of substring
        for (int i = 0; i < word.length(); i++) {
            // Inner loop for ending point of substring
            for (int j = i + 5; j <= word.length(); j++) { // Start from i + 5 to guarantee at least one of each vowel
                int consonantCount = 0;
                boolean[] vowelsPresent = new boolean[5]; // a, e, i, o, u

                // Count consonants and track vowels in the substring
                for (int t = i; t < j; t++) {
                    char c = word.charAt(t);
                    if (isVowel(c)) {
                        if (c == 'a') vowelsPresent[0] = true;
                        else if (c == 'e') vowelsPresent[1] = true;
                        else if (c == 'i') vowelsPresent[2] = true;
                        else if (c == 'o') vowelsPresent[3] = true;
                        else if (c == 'u') vowelsPresent[4] = true;
                    } else {
                        consonantCount++;
                    }
                }

                // Check if we have every vowel and exactly k consonants
                if (consonantCount == k && allVowelsPresent(vowelsPresent)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static boolean allVowelsPresent(boolean[] vowels) {
        // Check if all vowels are present
        for (boolean vowel : vowels) {
            if (!vowel) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1)); // Example test
    }
}
