package problemsolvingIII;

public class PathExistenceQueriesinaGraphI {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean[] pathExistenceQueriesF(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] union=new int[n];
        int k=0;
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i]-nums[i-1])<=maxDiff){
                k++;
            }
            union[i]=k;
        }
        int q=queries.length;
        boolean[] ans=new boolean[q];
        for(int i=0;i<q;i++){
            if(union[queries[i][0]]==union[queries[i][1]]){
                ans[i]=true;
            }
        }
        return ans;
    }
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q = queries.length;
        boolean[] res = new boolean[q];
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i]-nums[i-1])>maxDiff){
                unionNode(i,i-1);
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
        public static boolean[] pathExistenceQueriesFast(int n, int[] nums, int maxDiff, int[][] queries) {
            // component[i] = connected component containing node i
            int[] component = new int[n];
            int componentId = 0;
            component[0] = componentId;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] > maxDiff) {
                    componentId++;
                }
                component[i] = componentId;
            }

            boolean[] answer = new boolean[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int u = queries[i][0];
                int v = queries[i][1];
                answer[i] = component[u] == component[v];
            }

            return answer;
        }
}
