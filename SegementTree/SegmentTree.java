package SegementTree;

public class SegmentTree {
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildTree(arr, 0, 0, n - 1);
        for (int i = 0; i < 4 * n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        System.out.println(query(arr, 2, 5));
        update(3,9,arr);
        System.out.println(query(arr, 2, 5));
    }

    private static int buildTree(int[] arr, int i, int s, int e) {
        if (s == e) {
            tree[i] = arr[s];
            return tree[i];
        }
        int mid = (s + e) / 2;
        int l = buildTree(arr, i * 2 + 1, s, mid);
        int r = buildTree(arr, i * 2 + 2, mid + 1, e);
        return tree[i] = l + r;
    }

    public static int query(int[] arr, int i, int j) {
        return queryUtil( 0, i, j, 0, arr.length-1);
    }

    private static int queryUtil( int i, int qi, int qj, int si, int sj) {
        if (qi > sj || qj < si) {
            return 0;
        } else if (qi <= si && qj >= sj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int l = queryUtil(2*i + 1, qi, qj, si, mid);
            int r = queryUtil( 2*i + 2, qi, qj, mid + 1, sj);
            return l + r;
        }

    }
    public static  void update(int i,int val,int[] arr){
        int diff=val-arr[i];
        arr[i]=val;
        updateUtil(i,0,arr.length-1,0,diff);
    }

    private static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if(i>sj || i<si){
            return;
        }
        tree[idx]+=diff;
        if (si == sj) {
            return;
        }

        int mid = (si + sj) / 2;
        updateUtil(i, si, mid, idx * 2 + 1, diff);
        updateUtil(i, mid + 1, sj, idx * 2 + 2, diff);
    }

}
