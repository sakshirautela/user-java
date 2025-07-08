import java.util.*;

public class KthSmallestPathXORSum {
    
    public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
        int n = par.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int i = 1; i < n; i++) tree.get(par[i]).add(i);

        int[] inTime = new int[n], outTime = new int[n], xorPath = new int[n], euler = new int[n];
        xorPath[0] = vals[0];
        int time = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], state = top[1];
            if (state == 0) {
                inTime[node] = time;
                euler[time++] = xorPath[node];
                stack.push(new int[]{node, 1});
                List<Integer> children = tree.get(node);
                for (int i = children.size() - 1; i >= 0; i--) {
                    int child = children.get(i);
                    xorPath[child] = xorPath[node] ^ vals[child];
                    stack.push(new int[]{child, 0});
                }
            } else {
                outTime[node] = time - 1;
            }
        }

        int[] comp = Arrays.copyOf(euler, n);
        Arrays.sort(comp);
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (comp[i] != comp[i - 1]) comp[m++] = comp[i];
        }
        comp = Arrays.copyOf(comp, m);

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Arrays.binarySearch(comp, euler[i]);
        }

        int Q = queries.length;
        int blockSize = (int) Math.sqrt(n) + 1;

        class Qry {
            int l, r, k, idx, blk;
            Qry(int l, int r, int k, int idx) {
                this.l = l;
                this.r = r;
                this.k = k;
                this.idx = idx;
                this.blk = l / blockSize;
            }
        }

        Qry[] qs = new Qry[Q];
        for (int i = 0; i < Q; i++) {
            int u = queries[i][0], k = queries[i][1];
            qs[i] = new Qry(inTime[u], outTime[u], k, i);
        }

        Arrays.sort(qs, (a, b) -> {
            if (a.blk != b.blk) return Integer.compare(a.blk, b.blk);
            return (a.blk & 1) == 1 ? Integer.compare(a.r, b.r) : Integer.compare(b.r, a.r);
        });

        int valBlockSize = (int) Math.sqrt(m) + 1;
        int valBlockCount = (m + valBlockSize - 1) / valBlockSize;

        int[] freq = new int[m];
        int[] blkCnt = new int[valBlockCount];
        int[] ans = new int[Q];

        int L = 0, R = -1;

        for (Qry q : qs) {
            while (L > q.l) {
                int v = A[--L];
                if (freq[v]++ == 0) blkCnt[v / valBlockSize]++;
            }
            while (R < q.r) {
                int v = A[++R];
                if (freq[v]++ == 0) blkCnt[v / valBlockSize]++;
            }
            while (L < q.l) {
                int v = A[L++];
                if (--freq[v] == 0) blkCnt[v / valBlockSize]--;
            }
            while (R > q.r) {
                int v = A[R--];
                if (--freq[v] == 0) blkCnt[v / valBlockSize]--;
            }

            int k = q.k;
            int result = -1;
            for (int b = 0; b < valBlockCount; b++) {
                if (k > blkCnt[b]) {
                    k -= blkCnt[b];
                } else {
                    int start = b * valBlockSize;
                    int end = Math.min(start + valBlockSize, m);
                    for (int i = start; i < end; i++) {
                        if (freq[i] > 0 && --k == 0) {
                            result = comp[i];
                            break;
                        }
                    }
                    break;
                }
            }
            ans[q.idx] = result;
        }

        return ans;
    }
}
