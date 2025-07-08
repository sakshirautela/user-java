import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTree {
    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(5,new int[][]{{}}));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> hasAdded=new HashSet<>();
        List<Integer> li=new ArrayList<>();
        for(int e[]:edges){
            if(hs.contains(e[0]) && !hasAdded.contains(e[0])){
                li.add(e[0]);
                hasAdded.add(e[0]);
            }
            if(hs.contains(e[1])&& !hasAdded.contains(e[1])){
                hasAdded.add(e[1]);
                li.add(e[1]);
            }
            
            hs.add(e[0]);
            hs.add(e[1]);
        }
        return li;
    }
}