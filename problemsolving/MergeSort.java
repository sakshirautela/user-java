public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        // code here
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1=r-m;
        int temp[] = new int[r-m];
        for (int i = 0; i <n1; i++) {
            temp[i]=arr[m+i+1];
        }
        int temp2[] = new int[m - l + 1];
        int n2=m-l+1;
        for (int i = 0; i <n2; i++) {
            temp2[i]=arr[i+l];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (temp[i] <= temp2[j]) {
                arr[k] = temp[i];
                i++;
            }
            else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }
}