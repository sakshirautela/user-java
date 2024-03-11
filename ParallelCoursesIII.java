import java.util.*;

public class ParallelCoursesIII {
    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList();
        }
        for(int i=0;i<relations.length;i++){
            int s=relations[i][0];
            int dest=relations[i][1];
            graph[s-1].add(dest-1);
        }
        int[] cal=new int[n];
        int totaltime=0;
        for(int i=0;i<n;i++){
            totaltime=Math.max(totaltime,calTime(i,graph,time,cal));
        }
        return totaltime;
    }
    public static int calTime(int i,List<Integer>[] graph,int[] time,int[] cal){
        if(cal[i]!=0){
            return cal[i];
        }
        int pretime=0;
        for(int j=0;j<graph[i].size();j++){
            pretime=Math.max(pretime,calTime(graph[i].get(j),graph,time,cal));
        }
        cal[i]=pretime+time[i];
        return cal[i];
    }
    public static void main(String[] args){
        System.out.println(minimumTime(3,new int[][]{{1,3},{2,3}},new int[]{3,2,5}));
    }
}