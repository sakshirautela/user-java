import java.util.Arrays;

public class CounttheNumberofPossibleTriangles {
    public static void main(String[] args) {
        System.out.println(countTriangles(new int[] {}));
    }

    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        int result = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 2; i < n; i++) {
            int j = 0, k = i - 1;
            while (j<k) {
                if(arr[i]<arr[j]+arr[k]){
                    result+=k-j;
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}