package problemsolvingIII;

public class ConstructUniformParityArrayII {
    static void main() {
        System.out.println(uniformArray(new int[]{}));
    }
        public static boolean uniformArray(int[] nums1) {
                    int min = nums1[0];
                    boolean odd = false;

                    for (int i : nums1) {
                        min = Math.min(min, i);

                        if ((i & 1) == 1) {
                            odd = true;
                        }
                    }

                    return (min & 1) != 0 || !odd;
                }
}
