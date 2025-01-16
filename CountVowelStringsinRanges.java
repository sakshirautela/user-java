public class CountVowelStringsinRanges {
    public static void main(String args[]) {
        int[] res = vowelStrings(new String[] {}, new int[][] { {} });
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n ] ;
        int[] isValid = new int[words.length];
        String vowel = "aoiue";
        for (int i = 0; i < isValid.length; i++) {
            String s = words[i];
            if (vowel.indexOf(s.charAt(0)) != -1 && vowel.indexOf(s.charAt(s.length() - 1)) != -1) {
                isValid[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                s += isValid[j];
            }
            res[i] = s;
        }
        return res;
    }

    public int[] vowelStrings2(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (isVowelString(words[i])) {
                count[i + 1]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            count[i] += count[i - 1];
        }
        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            res[i++] = count[r + 1] - count[l];
        }
        return res;
    }

    public boolean isVowelString(String str) {
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1));
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}