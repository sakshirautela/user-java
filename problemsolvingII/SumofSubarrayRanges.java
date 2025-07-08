import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumofSubarrayRanges {
    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[] {3,1,2,4}));
    }

    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] leftRange = new int[n];
        int[] rightRange = new int[n];
        Arrays.fill(leftRange, -1);
        Arrays.fill(rightRange, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                leftRange[i] = st.peek();
            }
            st.push(i);
        }
        Deque<Integer> maxst = new ArrayDeque<>();
        for (int i = n-1; i >=0; i--) {
            while (!maxst.isEmpty() && nums[maxst.peek()] < nums[i]) {
                maxst.pop();
            }
            if (!maxst.isEmpty()) {
                rightRange[i] = maxst.peek();
            }
            maxst.push(i);
        }
        for (int left : leftRange) {
            System.out.print(left+" ");
        }
        System.out.println();
        for (int left : rightRange) {
            System.out.print(left+" ");
        }
        System.out.println();
        int result=0;
        for (int i = 0; i <n; i++) {
            result+=((rightRange[i]-i)-(i-leftRange[i]))*nums[i];
        }
        return result;
    }
}