import java.util.ArrayList;
import java.util.LinkedList;

import java.util.PriorityQueue;

public class ConnectingCitiesWithMinCost {
        public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},
                        {1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,0,6,0},
                        {4,7,7,0,0},
        };
        System.out.println(connectingCitiesWithMinCost(cities));
    }
    static class Info implements Comparable<Info>{
        int dest;
        int cost;
        Info(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        public int compareTo(Info s){
            return this.cost-s.cost;
        }
    }
    public static int connectingCitiesWithMinCost(int cities[][ ]){
        boolean visited[]= new boolean[cities.length];
        PriorityQueue<Info> q=new PriorityQueue();
        q.add(new Info(0,0));
        int finalcost=0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(!visited[curr.dest]){
                finalcost+=curr.cost;
                visited[ curr.dest]=true;  
                for(int i= 0 ;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        q.add(new Info(i,cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }
}
