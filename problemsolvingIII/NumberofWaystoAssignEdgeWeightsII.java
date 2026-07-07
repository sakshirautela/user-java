package problemsolvingIII;

import java.util.ArrayList;

public class NumberofWaystoAssignEdgeWeightsII {
    static void main() {
        int[] res=assignEdgeWeights(new int[][]{},new int[][]{});
        for(int i:res){
            System.out.print(i+" ");
        }
    }

    public static int[] assignEdgeWeights(int[][] edges,int[][] queries) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int h=dfsTree(list,queries[i][0],-1,queries[i][1]);
            res[i] = totalasignable(2, h - 1);
        }
        return res;
    }
    private static final int MOD = 1_000_000_007;

    private static int totalasignable(int x, int y) {
        long res = 1;
        long base = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            y >>= 1;
        }
        return (int) res;
    }
    private static int dfsTree(ArrayList<ArrayList<Integer>> list, int src, int par, int end) {
        if(src==end){
            return 0;
        }
        int res = 0;
        for (int dest : list.get(src)) {
            if(dest==end){
                return 0;
            }
            if(dest==par){
                continue;
            }
            res = Math.max(dfsTree(list, dest,src, end)+1, res);
        }
        return res;
    }
}
