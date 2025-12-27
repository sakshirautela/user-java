import java.util.HashSet;

public class MaximumProductOfWordLength {
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}));
    }

    public static int maxProduct(String[] words) {
        int n = words.length;
        int[] len = new int[n];
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = words[i].length();
            for (char ch : words[i].toCharArray()) {
                mask[i] |= (1 << (ch - 'a'));
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {

                    result = Math.max(len[i] * len[j], result);
                }
            }
        }
        return result;
    }
}