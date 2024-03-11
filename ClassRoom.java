import java.util.*;
public class ClassRoom{
    static class Edges{
        int src;
        int dest;
        Edges(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void CreateGraph(ArrayList<Edges> graph){
        for(int i=0;i<graph.size();i++){
            graph[i]=new ArrayList<Edges>();
        }
        graph[0].add(new Edges(0,2));
        graph[1].add(new Edges(1,2));
        graph[1].add(new Edges(1,3));
        graph[2].add(new Edges(2,0));
        graph[2].add(new Edges(2,1));
        graph[2].add(new Edges(2,3));
        graph[3].add(new Edges(3,1));
        graph[3].add(new Edges(3,2));
    }
    public static void mian(String args[]){
        int V=4;
        ArrayList<Edges> graph[]=new ArrayList[V];
        CreateGraph(graph);
       for(int i=0;i<graph[1].size();i++){
            Edges e= graph[1].get(i);
            System.out.println(e.dest);
       }
        
    }
}