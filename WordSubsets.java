import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[] {}, new String[] {}));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<String>();
        int n = words1.length;
        int m = words2.length;

        int[] bMaxFreq = new int[26];
        // Calculate maximum frequency for each character in words2
        for (int i = 0; i < m; i++) {
            int[] bArr = new int[26];
            for (char ch : words2[i].toCharArray()) {
                int idx = ch - 'a';
                bArr[idx]++;
                bMaxFreq[idx] = (bMaxFreq[idx] < bArr[idx]) ? bArr[idx] : bMaxFreq[idx];
            }
        }

        // Check each word in words1
        for (int i = 0; i < n; i++) {
            int[] aArr = new int[26];
            for (char ch : words1[i].toCharArray()) {
                aArr[ch - 'a']++;
            }

            if (checkSubset(bMaxFreq, aArr)) {
                list.add(words1[i]);
            }
        }

        return list;
    }

    static boolean checkSubset(int[] bArr, int[] aArr) {

        for (int i = 0; i < 26; i++) {
            if (bArr[i] > aArr[i]) {
                return false;
            }
        }

        return true;
    }

    public List<String> wordSubsets2(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] target = new int[26];

        for (String word : B) {
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                target[ch - 'a'] = Math.max(target[ch - 'a'], temp[ch - 'a']);
            }
        }

        for (String word : A) {
            int[] source = new int[26];
            for (char ch : word.toCharArray()) {
                source[ch - 'a']++;
            }

            if (subset(source, target)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean subset(int[] parent, int[] child) {
        for (int i = 0; i < 26; i++) {
            if (parent[i] < child[i])
                return false;
        }
        return true;
    }
}