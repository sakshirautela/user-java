package problemsolvingIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class VerticalSum {
    static void main() {
    }
    public static ArrayList<Integer> verticalSum(Node root) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        verticalSumUtil(root,0,map);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private static void verticalSumUtil(Node root, int i, TreeMap<Integer, Integer> map) {
        if(root == null) return;
        map.put(i,map.getOrDefault(i, 0)+root.data );
        verticalSumUtil(root.left, i-1, map);
        verticalSumUtil(root.right, i+1, map);
    }
}
