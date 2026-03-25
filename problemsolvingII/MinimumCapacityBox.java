public class MinimumCapacityBox {
    static void main() {
        System.out.println(minimumIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
    }

    public static int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if(result==-1 && capacity[i]>=itemSize){
                result = i;
            }else if (capacity[i] >= itemSize && capacity[i] < capacity[result]) {
                result =i;
            }
        }
        return result;
    }
}