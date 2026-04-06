import java.util.HashMap;
import java.util.HashSet;

public class MirrorFrequencyDistance {
    static void main() {
        System.out.println(mirrorFrequencyMoreOptimize("ab1z9"));
    }

    public static int mirrorFrequencyMoreOptimize(String s) {
        int n = s.length();
        int[] f = new int[128];
        for (int i = 0; i < n; i++) {
            f[s.charAt(i)]++;
        }
        int ans = 0;
        for (int i = 0; i < 13; i++) {
            if(i<5){
                ans+=Math.abs(f[48+i]-f[57-i]);
            }
            ans+=Math.abs(f[97+i]-f[122-i]);
        }
        return ans;
    }

    public static int mirrorFrequency(String s) {
        int n = s.length();
        HashMap<Character, Integer> cf = new HashMap<>();
        HashMap<Character, Integer> mf = new HashMap<>();
        HashSet<Character> c = new HashSet<>();
        HashSet<Character> m = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            char mirror = ' ';
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                mirror = (char) ('0' + '9' - ch);
            } else {
                mirror = (char) ('a' + ('z' - ch));
            }
            if (!c.contains(mirror) || !m.contains(ch)) {
                m.add(mirror);
                c.add(ch);
            }
            if (c.contains(ch)) {
                cf.put(ch, cf.getOrDefault(ch, 0) + 1);
            }
            if (m.contains(ch)) {
                mf.put(ch, mf.getOrDefault(ch, 0) + 1);
            }
        }
        for (char ch : cf.keySet()) {
            char mirror = ' ';
            if (ch >= '0' && ch <= '9') {
                mirror = (char) ('0' + '9' - ch);
            } else {
                mirror = (char) ('a' + ('z' - ch));
            }
            int freq = cf.get(ch);
            int freq2 = mf.getOrDefault(mirror, 0);
            result += Math.abs(freq2 - freq);
        }
        return result;
    }
}
