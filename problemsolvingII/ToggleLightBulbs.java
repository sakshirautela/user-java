import java.util.*;

public class ToggleLightBulbs {
    static void main() {
        System.out.println(toggleLightBulbs(new ArrayList<>()));
    }

    public List<Integer> toggleLightBulbsFast(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();
        int[] state = new int[101];
        int n = bulbs.size();
        for (int i = 0; i < n; i++) {
            int b = bulbs.get(i);
            state[b] ^= 1;
        }
        for (int i = 1; i < 101; i++) {
            if (state[i] == 1) {
                ans.add(i);
            }

        }
        return ans;
    }

    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int n = bulbs.size();
        HashSet<Integer> set = new HashSet<>();
        for (int bulb : bulbs) {
            if (set.contains(bulb)) {
                set.remove(bulb);
            } else {
                set.add(bulb);
            }
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}