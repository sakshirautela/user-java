public class XORQueriesofaSubarray {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int a = arr[queries[i][0]];
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                a = a ^ arr[j];
            }
            result[i] = a;
        }
        return result;
    }

    public int[] xorQueries2(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            if (i == 0) {
                res[k] = pre[j];
            } else {
                res[k] = pre[j] ^ pre[i - 1];
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] arr = xorQueries(new int[] {}, new int[][] { {} });
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
