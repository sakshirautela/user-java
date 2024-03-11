import java.util.PriorityQueue;

public class WeakSoldiers {
    public static class Row implements Comparable<Row>{
        int idx;
        int soldiers;
        Row(int idx, int soldiers){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row s){
            if(this.soldiers == s.soldiers){
                return this.idx - s.idx;
            }
            else{
                return this.soldiers - s.soldiers;
            }
        }
    }
    public static void main(String[] args) {
        int army[][] = {{1,0,1,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0; i < army.length; i++){
            int soldier = 0;
            for(int j = 0; j < army[i].length; j++){
                if(army[i][j] == 1){
                    soldier += army[i][j];
                }
            }
            pq.add(new Row(i, soldier));
        }
        int k = 2;
        while(k > 0){
            System.out.println(pq.remove().idx);
            k--;
        }
    }
}
