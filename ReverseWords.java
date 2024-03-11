public class ReverseWords {
    public static String reverseWords(String s) {
        String sample = s.trim();
        System.out.println(sample+"@");
        String result = "";
        String res = "";
        for (int i = sample.length() - 1; i >= 0; i--) {
            if (sample.charAt(i) == ' ' && sample.charAt(i + 1) == ' ') {
                continue;
            } else if (sample.charAt(i) == ' ') {
                result = result + " " + res;
                res = "";
            } else {
                res = sample.charAt(i) + res;
            }
        }
        result = result + " " + res;
        result=result.trim();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("     a good   example       "));
    }
}