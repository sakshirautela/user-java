
public class FindtheStudentthatWillReplacetheChalk {
    public int chalkReplacer2(int[] chalk, int k) {
        return getChalkReplacer(chalk, k);
    }

    public int getChalkReplacer(int[] chalk, int remaining_chalk) {
        int chalk_sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            chalk_sum += chalk[i];
            if (remaining_chalk - chalk_sum < 0) {
                return i;
            }
        }
        return getChalkReplacer(chalk, (int) (remaining_chalk % chalk_sum));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int idx = 0;
        while (k > 0) {
            k -= chalk[idx];
            if (k <= 0) {
                return idx;
            }
            idx++;
            if (idx == chalk.length) {
                idx = 0;
            }
        }
        return idx;
    }

    public static void main(String arga[]) {
        System.out.println(chalkReplacer(new int[] { 3, 4, 1, 2 }, 25));
    }
}
