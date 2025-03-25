public class CountTotalNumberofColoredCells {
    public static void main(String[] args) {
        System.out.println(coloredCells(4));
    }

    /*
     * Recognizing that the sum inside the parentheses is simply the arithmetic
     * series 1+2+...+(n−1), we use the formula for the sum of the first m natural
     * numbers:
     * 
     * 1+4×
     * 2
     * (n−1)×n
     * ​
     * 
     * 
     * Expanding and simplifying, we get:
     * 
     * 1+2×(n−1)×n
     */
    public static long coloredCells(int n) {
        return 1 + (long) n * (n - 1) * 2;
    }
}