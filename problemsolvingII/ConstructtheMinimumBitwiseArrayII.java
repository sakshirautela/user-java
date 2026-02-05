import java.util.ArrayList;
import java.util.List;

public class ConstructtheMinimumBitwiseArrayII {
    static void main() {
        int[] res = minBitwiseArray(new ArrayList<>(List.of(2, 3, 5, 7)));
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if(num==2){
                res[i] = -1;
            }
            else{
                res[i] = num & ~(((num+1)&(-(num+1)))>>1);
            }
        }

        return res;

    }

//    private static int getNum(int num) {
//        int low = 0;
//        int high = num;
//        while (low < high) {
//            int mid = low + (high - low+1) / 2;
//            if ((mid | (mid + 1)) < num) {
//                low = mid;
//            } else {
//                high = mid-1;
//            }
//        }
//        if (low == 0) {
//            return -1;
//        }
//        return low;
//    }
}
