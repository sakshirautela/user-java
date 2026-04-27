package problemsolvingIII;

public class TwoEqualSumSubarrays {
    static void main() {
        System.out.println(canSplit(new int[]{4,3,2,1}));
    }

    public static boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i <n; i++) {
            if(target==0){
                return true;
            }
            if(target<0){
                return false;
            }
            target -= arr[i];
        }
        return (target==0);
    }
}