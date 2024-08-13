import java.util.*;
public class MaximumImportanceRoads {
        public static long maximumImportance(int n, int[][] roads) {
        long[] inDegree=new long[n];
        for( int i=0;i<roads.length;i++){
            inDegree[roads[i][0]]++;
            inDegree[roads[i][1]]++;
        }
        Arrays.sort(inDegree);
        int val=1;
        long res=0;
        for( int i=0;i<inDegree.length;i++){
            res+=(inDegree[i]*val);
            val++;
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(maximumImportance(5,new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
}