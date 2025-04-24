import java.util.ArrayList;
import java.util.HashSet;

public class AlienDictionary {
    static class edge{
        char src;
        char dest;
        public edge(char src,char dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static String findOrder(String[] dict, int n, int k) {
        HashSet<Character> hs= new HashSet<Character>();
        ArrayList<Character> graph=new ArrayList<>();
    }
    public static void creatGraph(ArrayList<edge> graph,String[] dict,int n){
        for (int i = 1; i < n-1; i++) {
            if(dict[i]==dict[i+1]){
            }else{
                graph.add(new edge(dict[i].charAt(0),dict[i+1].charAt(0)));
            }
        }
    }

    public static void main(String args[]){
        System.out.println(findOrder(new String[]{"baa","abcd","abca","cab","cad"},5,4));
    }
}