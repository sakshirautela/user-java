import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ASCIIsum {
    public static void main(String[] args) {
        System.out.println(asciirange("abacab"));
    }

    public static ArrayList<Integer> asciirange(String s) {
        // code here
        int n = s.length();
        ArrayList<Integer> li = new ArrayList<>();
        HashMap<Character, Integer> pos = new HashMap<>();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pos.put(s.charAt(i), i);
            pre[i] = (i == 0) ? s.charAt(i) : pre[i - 1] + s.charAt(i);
        }
        System.out.println(pos);
        for (int i = 0; i < n; i++) {
            char start = s.charAt(i);
            if (pos.containsKey(start) && pos.get(start) > i) {
                li.add(pre[pos.get(start) - 1] - pre[i]);
                pos.remove(s.charAt(i));
            }
        }
        Collections.sort(li);
        return li;
    }
}
