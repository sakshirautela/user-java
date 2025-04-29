
class MaxProfitAssignmentWork {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            int a = 0;
            int j = 0;
            while (worker[i] >= difficulty[j] && a <= profit[j] && j<profit.length) {
                a = profit[j];
                j++;
            }
            res += a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                maxProfitAssignment(new int[] { 85, 47, 57 }, new int[] { 24, 66, 99 }, new int[] { 40, 25, 25 }));
    }
}
