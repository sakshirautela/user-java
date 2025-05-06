public class CountInversionsGFG {
    public static void main(String[] args) {
        System.out.println(inversionCount(new int[]{}));
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n=arr.length;
        int inversion=0;
        for (int j = 0; j < n; j++) {
            for (int i = j+1; i <n; i++) {
                if(arr[j]>arr[i]){
                    inversion++;
                }
            }
        }
        return inversion;
    }
}
