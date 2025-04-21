import java.util.HashMap;

public class RabbitsinForest {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[] { 0, 1, 2, 2, 2 }));
    }

    public static int numRabbits(int[] answers) {
        int rabbits = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : answers) {
            if (hm.containsKey(num) && hm.get(num) > 0) {
                hm.put(num, hm.getOrDefault(num, 0) - 1);
                continue;
            }
            hm.put(num, hm.getOrDefault(num, 0) + num);
            if (hm.get(num) >= 0) {
                rabbits += num + 1;
            }
        }
        return rabbits;
    }

    public int numRabbits2(int[] answers) {

        int n = answers.length;
        int[] count = new int[1000];

        int ans = 0;
        for (int x : answers) {
            if (++count[x] == 1)
                ans += x + 1;
            if (count[x] == x + 1)
                count[x] = 0;
        }

        return ans;
    }
}