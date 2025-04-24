import java.util.Arrays;

public class MinimumLinestoRepresentaLineChart {
    public static void main(String[] args) {
        System.out.println(minimumLines(new int[][] { {} }));
    }

    public static int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n <= 1) {
            return 0;
        }
        int lines = 1;
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int price = (stockPrices[1][1] - stockPrices[0][1]);
        int day = (stockPrices[1][0] - stockPrices[0][0]);
        for (int i = 2; i < n; i++) {
            int newprice = (stockPrices[i][1] - stockPrices[i - 1][1]);
            int newday = (stockPrices[i][0] - stockPrices[i - 1][0]);
            if ((newday != day || newprice != price) && newprice * day != price * newday) {
                lines++;
                day = newday;
                price = newprice;
            }
        }
        return lines;
    }
}