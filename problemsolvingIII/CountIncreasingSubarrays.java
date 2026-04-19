package problemsolvingIII;

public class CountIncreasingSubarrays {
    static void main() {
        System.out.println(countIncreasing(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public static int countIncreasing(int[] arr) {
        // code here
        int n = arr.length;
        int result = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                count++;
            }else{
                if(count > 1){
                    result+=(count*(count-1))/2;
                }
                count=1;
            }
        }
        if(count > 1){
            result+=(count*(count-1))/2;
        }
        return result;
    }
}
