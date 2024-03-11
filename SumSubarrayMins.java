import java.util.*;

public class SumSubarrayMins {
    public int sumSubarrayMins(int[] arr){
        int mod=1000000007;
        int left[]=new int[arr.length];
        int right[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        for (int i = 0; i < right.length; i++) {
            if(stack.empty()==false && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            left[i]=(stack.empty()==true)?-1:stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < right.length; i++) {
            System.out.print(left[i]+" ");
        }
        stack.clear();
        for (int i = right.length-1;i>=0; i--) {
            if (stack.empty() == false && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = (stack.empty() == true) ? arr.length : stack.peek();
            stack.push(i);
        }
        System.err.println();
        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i] + " ");
        }
        int sum = 0;
        for (int i = 0; i < right.length; i++) {
            sum=(sum+((i-left[i])*(right[i]-i))%mod*arr[i]%mod)%mod;
        }
        return sum;
    }

    public int sumSubarrayMins2(int[] arr) {
        int sum = 0;
        int mod=1000000007;
        for (int i = 0; i < arr.length; i++) {
            sum=(sum + helper(arr, i))%mod;
            
        }
        return sum;
    }

    private int helper(int[] arr, int i) {
        int minval=arr[i];
        int result = 0;
        for (int j = i; j < arr.length; j++) {
            minval=Math.min(arr[j], minval);
            result+=minval;
        }
        return result;
    }

    public static void main(String[] args) {
        SumSubarrayMins obj = new SumSubarrayMins();
        System.out.println(obj.sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
    }
}
