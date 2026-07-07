package problemsolvingIII;

import java.util.ArrayList;

public class RangeLCMQueries {
    static void main() {
        System.out.println(RangeLCMQuery(new int[]{2, 3, 4, 6, 8, 16}, new int[][]{{2,0,2}, {1, 3, 8}, {2, 2, 5}}));
    }

    public static ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        segmenttree = new long[4 * n];
        ArrayList<Long> ans = new ArrayList<>();
        segmentTree(0, 0, n - 1, arr);
        for (int[] q : queries) {
            if (q[0] == 2) {
                ans.add(segmentTreeQuery(0,0,n-1,q[1],q[2]));
            } else {
                segmentTreeUpdate(0,0,n-1,q[1],q[2],arr);
            }
        }
        return ans;
    }

    public static long[] segmenttree;

    public static long segmentTreeQuery(int idx,int l, int r,int ql,int qr) {
        if (l>qr || r<ql) {
            return 1;
        }
        if (ql <= l && r <= qr){
            return segmenttree[idx];
        }
        int mid = (l + r) / 2;
        return lcm(segmentTreeQuery(2 * idx + 1, l, mid,ql,qr ),
                segmentTreeQuery(2 * idx + 2, mid + 1, r, ql,qr));

    }
    public static void segmentTreeUpdate(int idx, int l, int r, int i, int val, int[] arr) {
        if (l == r && i == l) {
            arr[l]=val;
            segmenttree[idx] = val;
            return;
        }
        if(l==r){
            return;
        }
        int mid = (l + r) / 2;
        if(i <= mid){

        segmentTreeUpdate(2 * idx + 1, l, mid,i,val, arr);
        }else{

        segmentTreeUpdate(2 * idx + 2, mid + 1, r, i,val, arr);
        }
        segmenttree[idx] = lcm(segmenttree[2 * idx + 1], segmenttree[2 * idx + 2]);
    }
    public static void segmentTree(int idx, int l, int r, int[] arr) {
        if (l == r) {
            segmenttree[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        segmentTree(2 * idx + 1, l, mid, arr);
        segmentTree(2 * idx + 2, mid + 1, r, arr);
        segmenttree[idx] = lcm(segmenttree[2 * idx + 1], segmenttree[2 * idx + 2]);
    }

    private static long lcm(long l, long r) {
        return (l / gcd(l, r)) * r;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
