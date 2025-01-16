public class MinimumNumberofOperationstoMoveAllBallstoEachBox {
    public static void main(String[] args) {
        System.out.println(minOperations(""));
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    result[i] += Math.abs(j - i);
                }
            }
        }
        return result;
    }

    public int[] minOperations2(String boxes) {
        char ch[] = boxes.toCharArray();
        int i;
        int n = boxes.length();
        int right = 0;
        int left = 0;
        int ans = 0;
        for (i = 0; i < n; i++) {
            if (ch[i] == '1') {
                ans += i;
                right++;
            }

        }
        int res[] = new int[n];
        res[0] = ans;
        if (ch[0] == '1') {
            left++;
            right--;
        }
        for (i = 1; i < n; i++) {
            // System.out.println(ans+" "+left+" "+right);
            ans = ans - right;
            ans = ans + left;
            if (ch[i] == '1') {
                right--;
                left++;
            }
            res[i] = ans;
        }
        return res;
    }
}