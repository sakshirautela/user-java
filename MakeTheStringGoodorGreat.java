public class MakeTheStringGoodorGreat {
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            char curr = sb.charAt(i);
            char currNext = sb.charAt(i + 1);
            if (currNext - curr == 32 || currNext - curr == -32) {
                sb.delete(i, i + 2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
    }
}