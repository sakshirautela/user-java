import java.util.HashMap;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("abc", "cde", "eed"));
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length(), m = baseStr.length();
        String res = "";

        HashMap<Character, Character> hmap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hmap.put((char) ('a' + i), (char) ('a' + i));
        }
        for (int i = 0; i < n; i++) {
            char p1 = findParent(s1.charAt(i), hmap);
            char p2 = findParent(s2.charAt(i), hmap);
            if (p1 >= p2) {
                hmap.put(p1, p2);
            } else {
                hmap.put(p2, p1);
            }
        }
        for (int i = 0; i < m; i++) {
            res += findParent(baseStr.charAt(i), hmap);
        }

        return res;
    }

    public static Character findParent(Character ch, HashMap<Character, Character> hmap) {
        if (ch == hmap.get(ch))
            return ch;

        return findParent(hmap.get(ch), hmap);
    }

    int[] parent = new int[26];

    private int findUltPar(int x) {
        if (parent[x] != x) {
            parent[x] = findUltPar(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v) {
        int ultPar_u = findUltPar(u);
        int ultPar_v = findUltPar(v);

        if (ultPar_u != ultPar_v) {
            if (ultPar_u < ultPar_v) {
                parent[ultPar_v] = ultPar_u;
            } else {
                parent[ultPar_u] = ultPar_v;
            }
        }
    }

    public String smallestEquivalentString2(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';

            union(u, v);
        }

        for (int i = 0; i < baseStr.length(); i++) {
            int mappedChar = findUltPar(baseStr.charAt(i) - 'a');
            sb.append((char) (mappedChar + 'a'));
        }

        return sb.toString();
    }

    static int parent2[];

    public static int find(int val) {
        if (parent2[val] != val) {
            parent2[val] = find(parent2[val]);

        }
        return parent2[val];
    }

    public static void union3(int a, int b) {
        int leta = find(a);
        int letb = find(b);

        if (leta < letb) {
            parent2[letb] = leta;
        } else {
            parent2[leta] = letb;
        }
    }

    public String smallestEquivalentString3(String s1, String s2, String baseStr) {
        int n = baseStr.length();
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char chh = baseStr.charAt(i);
            res.append((char) (find(chh - 'a') + 'a'));
        }
        return res.toString();
    }
}