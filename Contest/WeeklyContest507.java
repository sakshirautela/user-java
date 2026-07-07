package Contest;

import java.rmi.MarshalException;

public class WeeklyContest507 {
    static void main() {
        System.out.println(maxDistance(""));
    }

    public static int maxDistance(String moves) {
        int x = 0, y = 0;
        int u = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else {
                u++;
            }
        }
        return Math.abs(x) + Math.abs(y) + Math.abs(u);
    }

    public static int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % 10 == x) {
                    long num = sum ;
                    while (num > x) {
                        num /= 10;
                    }
                    if (num == x) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}