import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {
    public static void main(String[] args) {
        System.out.println(maxRemoval(new int[]{2,0,2},new int[][]{{0,2},{0,2},{1,1}}));
    }
    public static  int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            operations += deltaArray[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.offer(queries[j][1]);
                j++;
            }
            while (
                operations < nums[i] && !heap.isEmpty() && heap.peek() >= i
            ) {
                operations += 1;
                deltaArray[heap.poll() + 1] -= 1;
            }
            if (operations < nums[i]) {
                return -1;
            }
        }
        return heap.size();
    }
    public int maxRemoval2(int[] nums, int[][] queries) {
        IntPriorityQueue pq = new IntPriorityQueue(queries.length + 1);
        pq.add(-1);
        int[][] ends = ends(nums.length, queries);
        int[] diff = new int[nums.length +1];
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) diff[i] += diff[i - 1];
            for (int end : ends[i]) {
                pq.add(end);
            }
            while (diff[i] < nums[i]) {
                int idx = pq.poll();
                if (idx < i) return -1;
                diff[i]++;
                diff[idx + 1]--;
                r++;
            }
        }
        return queries.length - r;
    }

    static int[][] ends(int len, int[][] queries) {
        int[] counts = new int[len];
        for (int[] q : queries) {
            counts[q[0]]++;
        }
        int[][] ends = new int[len][];
        for (int i = 0; i < len; i++) {
            ends[i] = new int[counts[i]];
        }
        for (int[] q : queries) {
            final int q0 = q[0];
            ends[q0][--counts[q0]] = q[1];
        }
        return ends;
    }

    public class IntPriorityQueue {
        public int[] vals;
        private int size;

        IntPriorityQueue(int maxSize) {
            this.vals = new int[maxSize];
        }

        void add(int v) {
            vals[size] = v;
            moveUp(size++);
        }

        int poll() {
            int r = vals[0];
            moveDown(0, vals[--size]);
            return r;
        }

        private void moveDown(int idx, int val) {
            while (true) {
                int l = idx * 2 + 1;
                if (l >= size) break;
                int r = l + 1;
                int toSwap = r < size && vals[r] > vals[l] ? r : l;
                if (val < vals[toSwap]) {
                    vals[idx] = vals[toSwap];
                    idx = toSwap;
                } else {
                    break;
                }
            }
            vals[idx] = val;
        }

        private void moveUp(int idx) {
            while (idx > 0) {
                int parent = (idx - 1) / 2;
                if (vals[idx] <= vals[parent]) {
                    break;
                }
                swap(idx, parent);
                idx = parent;
            }
        }

        void swap(int a, int b) {
            int old = vals[a];
            vals[a] = vals[b];
            vals[b] = old;
        }

        int size() {
            return size;
        }
    }
    public int maxRemoval3(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int m = queries.length;
        int n = nums.length;
        int[] end = new int[n + 1];
        int val = 0;
        int j = 0;
        
        for(int i = 0; i < n; ++i) {
            val -= end[i];
            while(j < m && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }

            while(val < nums[i]) {
                if(pq.isEmpty() || pq.peek() < i) return -1;
                end[pq.poll() + 1]++;
                val++;
            }
        }

        return pq.size();
    }
}