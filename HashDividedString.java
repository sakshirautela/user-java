public class HashDividedString {
    public static String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int numSubstrings = n / k;

        for (int i = 0; i < numSubstrings; i++) {
            String substring = s.substring(i * k, (i + 1) * k);
            int sum = 0;

            // Calculate the sum of the hash values of characters in the substring
            for (char c : substring.toCharArray()) {
                sum += (c - 'a');
            }

            // Find the remainder when divided by 26
            int hashedChar = sum % 26;

            // Convert hashedChar to corresponding character and append to result
            result.append((char) ('a' + hashedChar));
        }

        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(stringHash("abcd",2));
    
    }
}