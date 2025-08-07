public class LastMomentBeforeAllAntFallOut {

    public static void main(String[] args) {
        System.out.println(getLastMoment(5, new int[]{}, new int[]{}));
    }

    public static int getLastMoment(int n, int left[], int right[]) {
        // code here
        int r = right.length;
        int result = 0;
        for (int i = 0; i < r; i++) {
            int t = n - right[i];
            if (t > result) {
                result = t;
            }
        }
        int l = left.length;
        for (int i = 0; i < l; i++) {
            int t = left[i];
            if (t > result) {
                result = t;
            }
        }
        return result;
    }
}
