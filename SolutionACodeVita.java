import java.util.Scanner;

public class SolutionACodeVita {
    public static void selectionSort(int arr[], int[] B, int n) {
        for (int i = 0; i < n; i++) {
            int a = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[a] > arr[j]) {
                    a = j;
                }
            }
            if (a == i) {
                continue;
            } else {
                int temp = arr[i];
                arr[i] = arr[a];
                arr[a] = temp;
                temp = B[a];
                B[a] = B[i];
                B[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
            int m = sc.nextInt();
            int[] A = new int[m];
            for (int i = 0; i < m; i++) {
                A[i] = sc.nextInt();
            }

            int B[] = new int[m];
            for (int i = 0; i < m; i++) {
                B[i] = sc.nextInt();
            }

            int n = sc.nextInt();

            // Validate input for n
            if (n < 0 || n > m) {
                System.out.println("Invalid value of n");
                return;
            }

            // Validate input arrays
            if (A.length != B.length || m != A.length) {
                System.out.println("Invalid input arrays");
                return;
            }

            selectionSort(A, B, n);

            for (int i = 0; i < B.length; i++) {
                System.out.print(B[i]+" ");
            }
                    System.out.println();

    }
}
