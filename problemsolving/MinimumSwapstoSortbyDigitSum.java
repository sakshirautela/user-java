import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapstoSortbyDigitSum {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[] {15,89}));
    
    }
    private static class Pair {
        int val;
        int key;
        int idx;

        Pair(int v, int k, int i) {
            this.val = v;
            this.key = k;
            this.idx = i;
        }
    }

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    public int minSwaps2Fast(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], digitSum(nums[i]), i);
        }

        mergeSort(arr, 0, n - 1);

        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            P[i] = arr[i].idx;
        }

        boolean[] vis = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] || P[i] == i)
                continue;
            int cycleSize = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                j = P[j];
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private void mergeSort(Pair[] a, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) >>> 1;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private void merge(Pair[] a, int l, int m, int r) {
        Pair[] tmp = new Pair[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            Pair A = a[i];
            Pair B = a[j];
            if (A.key < B.key || (A.key == B.key && A.val <= B.val))
                tmp[k++] = a[i++];
            else
                tmp[k++] = a[j++];
        }
        while (i <= m)
            tmp[k++] = a[i++];
        while (j <= r)
            tmp[k++] = a[j++];
        System.arraycopy(tmp, 0, a, l, tmp.length);
    }
    public static int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, (a, b) -> {
            int sa = sum(a);
            int sb = sum(b);
            return sa != sb ? sa - sb : a - b;  
        });
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],i);
        }
        int result = 0;
        for (int index = 0; index < n; index++) {
            int value=sorted[index];
            if(hm.get(value)==index){
                continue;
            }
            int idx=hm.get(value);
            swap(idx,index,nums);
            hm.put(nums[idx],idx);
            result++;
        }
        return result;
    }

    private static void swap(int idx, int index,int[] nums) {
        int temp=nums[idx];
        nums[idx]=nums[index];
        nums[index]=temp;
    }
}