import java.util.*;

public class FindWinnersWinOrLoss1 {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> win=new HashMap();
        HashMap<Integer,Integer> loss=new HashMap();
        for(int i=0;i<matches.length;i++){
            win.put(matches[i][0],win.getOrDefault(matches[i][0],0)+1);
            loss.put(matches[i][1],loss.getOrDefault(matches[i][1],0)-1);
        }
        System.out.println(win);
        System.out.println(loss);
        List<List<Integer>> list=new ArrayList();
        list.add(new ArrayList());
        list.add(new ArrayList());
        for(int i:win.keySet()){
            if(!loss.containsKey(i))
                list.get(0).add(i);
        }
        for(int i:loss.keySet()){
            if(loss.get(i)==-1 )
                list.get(1).add(i);
        }
        return list;
    }
    public static void main(String[] args) {
        FindWinnersWinOrLoss1 obj=new FindWinnersWinOrLoss1();
        System.out.println(obj.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }
}