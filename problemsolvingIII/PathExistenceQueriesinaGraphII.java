package problemsolvingIII;

import java.util.Arrays;

public class PathExistenceQueriesinaGraphII {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q = queries.length;
        boolean[] res = new boolean[q];
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        int[][] node_vals = new int[n][2];
        for (int i = 0; i < n; i++) {
            node_vals[i][0]=i;
            node_vals[i][1]=nums[i];
        }
        Arrays.sort(node_vals, (o1, o2) -> o1[1]-o2[1]);
        for(int i=1;i<n;i++){
            if(Math.abs(node_vals[i][1]-node_vals[i-1][1])>maxDiff){
                unionNode(node_vals[i][0],node_vals[i-1][0]);
            }
        }
        for (int i = 0; i < q; i++) {
            if(findNode(queries[i][0])==findNode(queries[i][1])) {
                res[i] = true;
            }
        }
        return res;
    }

    static int[] nodes;

    private void unionNode(int i, int j) {
        int pi = findNode(i);
        int pj = findNode(j);
        if (pi != pj) {
            nodes[pi] = pj;
        }
    }

    private int findNode(int i) {
        if (nodes[i] == i) {
            return i;
        }
        return nodes[i] = findNode(nodes[i]);
    }
}
