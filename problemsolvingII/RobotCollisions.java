import java.util.*;

public class RobotCollisions {
    static void main() {
        System.out.println(survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR"));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<positions.length;i++) {
            Pair pair=new Pair(positions[i],healths[i],directions.charAt(i));
            pq.add(pair);
        }
        Stack<Pair> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Pair> set=new HashMap<>();
        for(int j=0;j<healths.length;j++) {
            Pair p=pq.remove();
            if(p.direction=='L'){
                if(stack.isEmpty()){
                    set.put(p.position,p);
                }else{
                    if(stack.peek().health<p.health){
                        stack.remove(stack.peek());
                    }else{
                        set.put(p.position,p);
                    }
                }
            }else{
                stack.add(p);
            }
        }
        while(!stack.isEmpty()){
            Pair p=stack.pop();
            set.put(p.position,p);
        }
        System.out.println(set);
        for(int j=0;j<healths.length;j++){
            if(set.containsKey(positions[j])){
                list.add(set.get(positions[j]).health);
            }
        }
        return list;
    }

    static class Pair implements Comparable<Pair> {
        int health;
        int position;
        char direction;

        public Pair(int position, int health, char direction) {
            this.health = health;
            this.position = position;
            this.direction = direction;
        }

        @Override
        public int compareTo(Pair o) {
            return this.position - o.position;
        }
    }
}