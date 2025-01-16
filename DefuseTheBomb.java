public class DefuseTheBomb {
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; j++) {
                    sum += code[j % n];
                }
            } else {
                for (int j = i - Math.abs(k); j < i; j++) {
                    sum += code[(j + n) % n];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public int[] decrypt2(int[] code, int k) {
        int[] results = new int[code.length];

        if (k == 0) {
            return results;
        }

        int start = 1;
        int end = k;
        int sum = 0;

        if (k < 0) {
            start = code.length - Math.abs(k);
            end = code.length - 1;
        }

        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < code.length; i++) {
            results[i] = sum;
            sum -= code[(start) % code.length];
            sum += code[(end + 1) % code.length];
            start++;
            end++;
        }

        return results;
    }

    public static void main(String args[]) {
        int[] res = decrypt(new int[] { 2, 4, 9, 3 }, -2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}