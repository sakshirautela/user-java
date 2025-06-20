import java.util.ArrayList;
import java.util.List;

public class AreaOfTheBox{
    public static ArrayList<Long> countSquareAreas(List<int[]> queries) {
        ArrayList<Long> results = new ArrayList<>();

        for (int[] query : queries) {
            int rows = query[0];
            int cols = query[1];
            int maxSize = Math.min(rows, cols);
            long totalWays = 0;

            for (int size = 1; size <= maxSize; size++) {
                long ways = (long)(rows - size + 1) * (cols - size + 1);
                totalWays += ways;
            }

            results.add(totalWays);
        }

        return results;
    }

    public static void main(String[] args) {
        List<int[]> queries = new ArrayList<>();
        queries.add(new int[]{5, 3});

        ArrayList<Long> result = countSquareAreas(queries);
        System.out.println(result); // Output: [26]
    }
}