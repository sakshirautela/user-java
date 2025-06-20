import java.util.PriorityQueue;

public class MinimumDeletionsforAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.err.println(minDeletion("abc", 2));
    }

    public static int minDeletion(String s, int k) {
        int[] freq = new int[26];
        for (char i : s.toCharArray()) {
            freq[i - 'a']++;
        }
        int distinct = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }
        while (!pq.isEmpty() && pq.size() > k) {
            distinct += pq.remove();
        }
        return distinct;
    }

    public int minDeletionFast(String s, int k) {
        int i, X = 0, j = 0, sum = 0;
        int[] ch = new int[26];
        for (i = 0; i < 26; i++) {
            ch[i] = 0;
        }
        for (i = 0; i < s.length(); i++)
            ch[s.charAt(i) - 'a']++;
        for (i = 0; i < 26; i++) {
            if (ch[i] != 0) {
                X++;

            }
        }
        if (X <= k)
            return 0;
        else {
            int g;
            sum = 0;
            int z = 0, min = 0;
            j = X - k;
            for (g = j; g > 0; g--) {
                for (i = 0; i < 26; i++) {
                    if (ch[i] != 0) {
                        min = ch[i];
                        break;
                    }
                }
                for (i = 0; i < 26; i++) {
                    if (ch[i] != 0) {
                        if (ch[i] <= min) {
                            min = ch[i];

                            z = i;
                        }
                    }

                }

                sum = sum + min;
                ch[z] = 0;

            }

            return sum;

        }
    }
}