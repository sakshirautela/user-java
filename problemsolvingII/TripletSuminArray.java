import java.util.Arrays;

public class TripletSuminArray {
    public static void main(String[] args) {
        System.out.println(hasTripletSum(new int[]{},4));
    }
    public static boolean hasTripletSum(int arr[], int target) {
        // code Here
        Arrays.sort(arr);
        int n=arr.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;

            int requiredSum = target - arr[i];
            while (l < r) {
                if (arr[l] + arr[r] == requiredSum)
                    return true;
                if (arr[l] + arr[r] < requiredSum)
                    l++;
                else if (arr[l] + arr[r] > requiredSum)
                    r--;
            }
        }

        return false;
    }
}
