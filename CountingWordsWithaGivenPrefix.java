public class CountingWordsWithaGivenPrefix {
    public static void main(String arhs[]) {
        System.out.println(prefixCount(new String[], ""));
    }

    public static int prefixCount(String[] words, String pref) {
        int result = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(pref) == 0) {
                result++;
            }
        }
        return result;
    }
}