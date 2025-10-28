public class FindtheMinimumAmountofTimetoBrewPotions
{
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1,5,2,4},new int[]{5,1,4,2}));
    }
    public long minTimeFaster(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] acc = new long[n + 1];
        for (int i = 0; i < n; i++) {
            acc[i + 1] = acc[i] + skill[i];
        }
        long t = 0, t2 = 0;
        for (int j = 1; j < m; j++) {
            t2 = 0;
            for (int i = 0; i < n; i++) {
                t2 = Math.max(t2, t + mana[j - 1] * acc[i + 1] - mana[j] * acc[i]);
            }
            t = t2;
        }
        return t + mana[m - 1] * acc[n];
    }

        public static long minTime(int[] skill, int[] mana) {
            int n = skill.length;
            int m = mana.length;

            long[] ft = new long[n];

            for (int j = 0; j < m; j++) {
                long x = mana[j];
                long current = ft[0];

                for (int i = 1; i < n; i++) {
                    current = Math.max(current + (long) skill[i - 1] * x, ft[i]);
                }

                ft[n - 1] = current + (long) skill[n - 1] * x;

                for (int i = n - 2; i >= 0; i--) {
                    ft[i] = ft[i + 1] - (long) skill[i + 1] * x;
                }
            }

            return ft[n - 1];
    }
}
