public class QuickSortGFG {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(high>low){
            int pi=partition(arr,low,high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1, high);
        return i+1;

    }
    private static void swap(int[] arr, int i, int j) {
         int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
          int n = arr.length;
      
        quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
