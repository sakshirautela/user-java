import java.util.ArrayList;
import java.util.List;

public class FindMirrorScoreofaString {
    public static void main(String[] args) {
        System.out.println(calculateScore("eockppxdqclkhjgvnw"));
    }
    static char mirror[]={'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
    public static long calculateScore(String s) {
        int len=s.length();
        long res=0;
        boolean[] marked=new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j =i-1;j>=0;j--) {
                if(!marked[j] && s.charAt(j)==mirror[s.charAt(i)-'a']){
                    res+=(i-j);
                    marked[j]=true;
                    break;
                }
            }
        }
        return res;

    }
    public static long calculateScore2Main(String s) {
     List<List<Integer>> mirror = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            mirror.add(new ArrayList<>());
        }

        long score = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = 'z' - s.charAt(i);

            if (!mirror.get(idx).isEmpty()) {
                int j = mirror.get(idx).get(mirror.get(idx).size() - 1);
                score += (long) (i - j);
                mirror.get(idx).remove(mirror.get(idx).size() - 1);
            } else {
                int idx2 = s.charAt(i) - 'a';
                mirror.get(idx2).add(i);
            }
        }

        return score;
    }
}