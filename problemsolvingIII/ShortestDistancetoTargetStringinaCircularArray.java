package problemsolvingIII;

public class ShortestDistancetoTargetStringinaCircularArray {
    static void main() {
        System.out.println(closestTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));
    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                if (i < startIndex) {
                    min = Math.min(min, startIndex - i);
                    min = Math.min(min, i + n - startIndex);
                } else {
                    min = Math.min(min, i - startIndex);
                    min = Math.min(min, n - i + startIndex);
                }
            }
//            int forward = (startIndex + step) % n;
//            int backward = (startIndex - step + n) % n;
//            if (words[forward].equals(target) || words[backward].equals(target)) {
//                return step;
//            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
