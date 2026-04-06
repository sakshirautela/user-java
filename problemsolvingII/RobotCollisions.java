import java.util.*;

public class RobotCollisions {
    static void main() {
        System.out.println(survivedRobotsHealthsOptimize(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
    }

    public static List<Integer> survivedRobotsHealthsOptimize(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(a -> positions[a]));
            Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int head = indexes[i];
            char c = directions.charAt(head);
            if (c == 'L') {
                while (!stack.isEmpty() && healths[stack.peek()]<healths[head]) {
                    healths[stack.peek()]=0;
                    stack.pop();
                    healths[head]--;
                }
                if(!stack.isEmpty() ){
                    if (healths[stack.peek()] == healths[head]) {
                        healths[stack.peek()] = 0;
                        stack.pop();
                        healths[head] = 0;
                    } else {
                        healths[stack.peek()]--;
                        healths[head] = 0;
                    }
                }
            } else {
                stack.push(head);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        ArrayList<Pair> arr = new ArrayList<>();
        int n = positions.length;
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(positions[i], healths[i], directions.charAt(i));
            arr.add(pair);
        }
        arr.sort((a, b) -> a.position - b.position);
        Stack<Pair> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Pair> set = new HashMap<>();
        for (Pair p : arr) {
            if (p.direction == 'L') {
                while (!stack.isEmpty() && stack.peek().health < p.health) {
                    stack.pop();
                    p.health = p.health - 1;
                }
                if (!stack.isEmpty() && stack.peek().health == p.health) {
                    stack.pop();
                    continue;
                }
                if (stack.isEmpty()) {
                    set.put(p.position, p);
                }
                if (!stack.isEmpty() && stack.peek().health > p.health) {
                    Pair a = stack.pop();
                    a.health = a.health - 1;
                    stack.push(a);
                }
            } else {
                stack.push(p);
            }
        }
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            set.put(p.position, p);
        }
        for (int j = 0; j < healths.length; j++) {
            if (set.containsKey(positions[j])) {
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