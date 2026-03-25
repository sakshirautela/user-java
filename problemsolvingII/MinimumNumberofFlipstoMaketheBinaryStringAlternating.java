public class MinimumNumberofFlipstoMaketheBinaryStringAlternating {
    static void main() {
        System.out.println(minFlips(""));
    }

    public static int minFlips(String s) {
        int n = s.length();
        int res = n;
        int[] operations = {0, 0};

        for (int i = 0; i < n; i++)
            operations[(s.charAt(i) ^ i) & 1]++;

        for (int i = 0; i < n; i++) {
            operations[(s.charAt(i) ^ i) & 1]--;
            operations[(s.charAt(i) ^ (n + i)) & 1]++;
            res = Math.min(res, Math.min(operations[0], operations[1]));
        }

        return res;
    }
}
