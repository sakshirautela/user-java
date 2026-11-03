package problemsolvingIII;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    static void main() {
        System.out.println(leastInterval(new char[]{},4));
    }
    static class Freq implements Comparable<Freq>{
        int freq;
        char ch;
        Freq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq o) {
            return o.freq - this.freq;
        }
    }
    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int result=0;
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char c : map.keySet()) {
            pq.add(new Freq(c,map.get(c)));
        }
        int prev=-1;
        int window=n;
        while (!pq.isEmpty()) {
            Freq freq = pq.poll();
            if (prev == -1 || freq.freq < prev) {
                result++;
            }
            prev = freq.ch - 'A';
        }
        return result;
    }
}
