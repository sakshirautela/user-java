public class ValidWord {
    public static void main(String[] args) {
        System.out.println(isValid("abc12@"));
    }

    public static boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }
        int vowels = 0;
        int consonants = 0;
        for (char ch : word.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                vowels++;
            } else if (ch >= '0' && ch <= '9') {
                continue;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                consonants++;
            } else {
                return false;
            }
        }
        return (vowels >= 1 && consonants >= 1);
    }


    public boolean isValidFast(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                    hasVowel = true;
                    break;
                case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y',
                        'z',
                        'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X',
                        'Y', 'Z':
                    hasConsonant = true;
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    break;
                default:
                    return false;
            }
        }

        return hasVowel && hasConsonant;
    }
}