import java.util.Arrays;

public class MinimumTimeforKConnectedComponents {
    public static void main(String[] args) {
        System.out.println(minTime(4,new int[][]{{}},4));
    }

    static int par[];
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static boolean union(int a, int b) {
        int para = find(a);
        int parb = find(b);
        if (para == parb) {
            return false;
        }
        par[para] = parb;
        return true;
    }

    public static int minTime(int n, int[][] edges, int k) {
          if (edges.length == 0) {
            return 0;
        }
        Arrays.sort(edges, (a, b) -> (b[2] - a[2]));
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        int comp = n;
        for (int j = 0; j < edges.length; j++) {
            int[] ed = edges[j];
            if (union(ed[0], ed[1])) {
                comp--;
            }
            if (comp < k) {
                return ed[2]; 
            }
        }
        return 0;
    }
}