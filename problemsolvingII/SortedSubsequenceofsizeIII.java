import java.util.ArrayList;

public class SortedSubsequenceofsizeIII {
    static void main() {
        System.out.println(find3NumbersO1(new int[]{104, 753, 852, 120, 676, 984}));
    }

    public static ArrayList<Integer> find3NumbersO1(int[] arr) {
        int n = arr.length;
        int first = Integer.MAX_VALUE;
        int second = first;
        int prev = second;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (first >= num) {
                first = num;
            } else if (second >= num) {
                prev = first;
                second = num;
            } else {
                ans.add(prev);
                ans.add(second);
                ans.add(num);
                return ans;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int[] small = new int[n];
        int[] big = new int[n];
        small[0] = arr[0];
        big[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            small[i] = Math.min(small[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            big[i] = Math.max(big[i + 1], arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (small[i - 1] < arr[i] && arr[i] < big[i + 1]) {
                ans.add(small[i]);
                ans.add(arr[i]);
                ans.add(big[i]);
                break;
            }
        }
        return ans;
    }
}