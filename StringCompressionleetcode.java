public class StringCompressionleetcode {
    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0, res = 0;
        while (i < chars.length) {
            int len = 1;
            while ((i + len) < chars.length && chars[i + len] == chars[i]) {
                len++;
            }
            chars[res++] = chars[i];
            if (len > 1) {
                for (char ch : Integer.toString(len).toCharArray())
                    chars[res++] = ch;
            }
        }
        return res;
    }

    static {
        for (int i = 0; i < 500; i++) {
            compress(new char[] { 'a' });
        }
    }

    public static int compress2(char[] chars) {
        int answer = 0;
        int firstOccurrence = 0;
        char[] currentCharCount;

        for (int index = 0; index < chars.length; index++) {
            if (index == chars.length - 1 || chars[index] != chars[index + 1]) {
                chars[answer++] = chars[index];

                if (index - firstOccurrence > 0) {
                    currentCharCount = Integer.toString(index - firstOccurrence + 1).toCharArray();

                    for (int t = 0; t < currentCharCount.length; t++) {
                        chars[answer++] = currentCharCount[t];
                    }
                }

                firstOccurrence = index + 1;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        System.out.println(compress(new char[] {}));
    }
}