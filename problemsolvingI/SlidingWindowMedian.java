import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        double[] result = medianSlidingWindow(new int[] {2147483647,2147483647}, 2);
        for (double i : result) {
            System.out.print(i+"  ");
        }
    }
    public double[] medianSlidingWindow2(int[] nums, int k) {
        MedianFinder mf = new MedianFinder(nums.length + 1);
        double[] r = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            mf.addNum(nums[i]);
        }
        r[0] = mf.findMedian();
        for (int i = 1; i < r.length; i++) {
            mf.addNum(nums[i + k - 1]);
            mf.removeNum(nums[i - 1]);
            r[i] = mf.findMedian();
        }
        return r;
    }

    public static class MedianFinder {
        private final IntPriorityQueue left;
        private final IntPriorityQueue right;

        public MedianFinder(int size) {
            left = new IntPriorityQueue(size + 1);
            right = new IntPriorityQueue(size + 1);
            left.add(Integer.MIN_VALUE);
            right.add(Integer.MIN_VALUE);
        }

        public void addNum(int num) {
            if (num < left.peek()) {
                left.add(num);
            } else if (num > invert(right.peek())) {
                right.add(invert(num));
            } else if (left.size() <= right.size()) {
                left.add(num);
            } else {
                right.add(invert(num));
            }
        }

        public void removeNum(int num) {
            if (num <= left.peek()) {
                left.remove(num);
            } else {
                right.remove(invert(num));
            }
        }

        int invert(int num) {
            return -num - 1;
        }

        public double findMedian() {
            while (left.size() < right.size()) left.add(invert(right.poll()));
            while (left.size() > right.size() + 1) right.add(invert(left.poll()));
            return left.size() > right.size() ? left.peek() : 0.5 * left.peek() + 0.5 * invert(right.peek());
        }

        static final class IntMap {
            private final Entries[] entries;

            IntMap(int size) {
                this.entries = new Entries[size];
//            this.toClear = new Entries[size];
            }

            int get(int key) {
                int idx = Math.abs(key % entries.length);
                Entries e = entries[idx];
                return e == null ? 0 : e.get(key);
            }

            boolean remove(int key) {
                int idx = Math.abs(key % entries.length);
                Entries e = entries[idx];
                return e != null && e.remove(key);
            }

            int add(final int key) {
                int idx = Math.abs(key % entries.length);
                Entries e = entries[idx];
                if (e == null) {
                    e = entries[idx] = new Entries();
                }
                return e.add(key);
            }
        }

        static final class Entries {
            int len;
            int[][] mappings = new int[2][];

            int get(int key) {
                final int[] r = getV(key);
                return r == null ? 0 : r[1];
            }

            boolean remove(int key) {
                final int[] r = getV(key);
                if (r == null || r[1] == 0) return false;
                r[1]--;
                return true;
            }

            int[] getV(int key) {
                for (int i = 0; i < len; i++) {
                    final int[] m = mappings[i];
                    if (key == m[0]) {
                        return m;
                    }
                }
                return null;
            }

            int add(final int key) {
                final int[] existing = getV(key);
                if (existing != null) {
                    return existing[1]++;
                }
                if (len == mappings.length) {
                    mappings = Arrays.copyOf(mappings, len * 2);
                }
                mappings[len++] = new int[]{key, 1};
                return 0;
            }
        }

        public static class IntPriorityQueue {
            IntMap map;
            private int[] vals;
            private int size;
            private int pendingRemoves = 0;

            IntPriorityQueue(int size) {
                this.vals = new int[size];
                this.map = new IntMap(size);
            }

            void add(int v) {
                vals[size] = v;
                moveUp(size++);
            }

            void remove(int v) {
                map.add(v);
                pendingRemoves++;
            }

            int peek() {
                while (map.remove(vals[0])) {
                    moveDown(vals[--size]);
                    pendingRemoves--;
                }
                return vals[0];
            }

            int poll() {
                int r = peek();
                moveDown(vals[--size]);
                return r;
            }

            private void moveDown(int val) {
                for (int idx = 0; ; ) {
                    int l = idx * 2 + 1;
                    if (l >= size) {
                        vals[idx] = val;
                        return;
                    }
                    int r = l + 1;
                    int candidate = r < size && vals[r] > vals[l] ? r : l;
                    if (val < vals[candidate]) {
                        vals[idx] = vals[candidate];
                        idx = candidate;
                    } else {
                        vals[idx] = val;
                        return;
                    }
                }
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
                return size - pendingRemoves;
            }
        }
    }
    static ArrayList<Double> al;
    public static double[] medianSlidingWindowTLE(int[] nums, int k) {
        int n=nums.length;
        al=new ArrayList<>();
        double[] result=new double[n-k+1];
        for(int i=0;i<k-1;i++){
            add((double) nums[i]);

        }
        int idx=0;
        for (int i = k-1; i < n; i++) {
            add((double) nums[i]);
            if(k%2==1){
                result[idx] =al.get(k/2);
            }else{
                System.out.println(al.get((k-1)/2));
                result[idx]= (al.get((k)/2).equals(al.get((k-1)/2)))?al.get((k)/2):(al.get(k/2)+al.get((k-1)/2))/2.0;
            }
            idx++;
            al.remove(Double.valueOf(nums[i-k+1]));
        }
        return result;
    }
    private static void add(Double i) {
        for (int index = 0; index < al.size(); index++) {
            if(al.get(index)>i){
                al.add(index,i);
                return;
            }
        }
        al.add(i);
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        Map<Integer, Integer> outgoingNum = new HashMap<>();
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            smallList.offer(nums[i]);
        }

        for (int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        int balance = 0;
        int index = 0;

        for (int i = k;; i++) {
            if (k % 2 == 1) {
                medians[index] = smallList.peek();
            } else {
                medians[index] = ((double) smallList.peek() + largeList.peek()) / 2.0;
            }

            if (i >= nums.length)
                break;

            int outNum = nums[i - k];
            int inNum = nums[i];
            index++;

            balance += (outNum <= smallList.peek()) ? -1 : 1;

            outgoingNum.put(outNum, outgoingNum.getOrDefault(outNum, 0) + 1);

            if (inNum <= smallList.peek()) {
                balance++;
                smallList.offer(inNum);
            } else {
                balance--;
                largeList.offer(inNum);
            }

            if (balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0) {
                largeList.offer(smallList.poll());
            }

            balance = 0;

            while (outgoingNum.getOrDefault(smallList.peek(), 0) > 0) {
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.peek()) - 1);
                smallList.poll();
            }

            while (!largeList.isEmpty() && outgoingNum.getOrDefault(largeList.peek(), 0) > 0) {
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.peek()) - 1);
                largeList.poll();
            }
        }

        return medians;
    }
}
