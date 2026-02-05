import java.util.HashMap;

public class CountCeaserCipherPairs {
    static void main() {
        System.out.println(countPairs(new String[]{"fusion","layout"}));
    }

    public static long countPairs(String[] words) {
        int n = words.length;
        long result = 0;
        HashMap<String,Long> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String norm=isvalid(words[i]);
            long count = map.getOrDefault(norm, 0L);
            result += count;
            map.put(norm, count + 1);
        }
        return result;
    }

    private static String isvalid(String w) {
        int shift = w.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();

        for (char c : w.toCharArray()) {
            char normalizedChar = (char) ((c - shift - 'a' + 26) % 26 + 'a');
            sb.append(normalizedChar);
        }
        return sb.toString();
    }
}
