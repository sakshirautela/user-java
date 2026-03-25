import java.util.ArrayList;

public class MaximizeSpanningTreeStabilitywithUpgrades {
    static void main() {
        System.out.println(maxStability(3, new int[][]{{}}, 3));
    }

    public static int maxStability(int n, int[][] edges, int k) {
        int len = edges.length;
        ArrayList<int[]> mandatory = new ArrayList<int[]>();
        ArrayList<int[]> notmandatory = new ArrayList<int[]>();
        for (int[] edge : edges) {
            if (edge[3] == 1) {

                mandatory.add(edge);
            } else {
                notmandatory.add(edge);
            }
        }
        if(mandatory.size()>=n || (mandatory.size()+notmandatory.size())<n-1) {
            return -1;
        }
return 0;
    }
}
