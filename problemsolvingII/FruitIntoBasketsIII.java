public class FruitIntoBasketsIII {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{35,61}, new int[]{76,56}));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int result = 0;
        int i = 0;
        int j = 0;
        //Arrays.sort(baskets);
        while (i < n && j < n) {
            if (fruits[i] > baskets[j]) {
                result++;
            }
            i++;
            j++;
        }
        return result;
    }
}
