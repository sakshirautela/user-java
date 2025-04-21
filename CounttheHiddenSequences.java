public class CounttheHiddenSequences {
    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{},3,4));
    }
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0, y = 0, cur = 0;
        for (int d : differences) {
            cur += d;
            x = Math.min(x, cur);
            y = Math.max(y, cur);
            if (y - x > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (y - x) + 1;
    }
}