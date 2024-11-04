import java.util.ArrayList;
import java.util.List;

public class FindAllTripletswithZeroSumGFG {
    public static List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        // Generating all triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    // If the sum of triplet equals to zero
                    // then add it's indexes to the result
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(i);
                        triplet.add(j);
                        triplet.add(k);
                        res.add(triplet);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTriplets(new int[] {}));
    }
}
