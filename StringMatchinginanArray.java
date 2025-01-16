import java.util.ArrayList;
import java.util.List;

public class StringMatchinginanArray {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[] {}));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> li = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (words[j].indexOf(words[i]) != -1) {
                    li.add(words[i]);
                    break;
                }
            }
        }
        return li;
    }

    public List<String> stringMatching2(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (isSubstringOfSomeoneButIt(words, curr, i)) {
                result.add(curr);
            }
        }

        return result;
    }

    private static boolean isSubstringOfSomeoneButIt(String[] words, String curr, int indexToExclude) {
        for (int j = 0; j < words.length; j++) {
            if (j == indexToExclude)
                continue;
            String other = words[j];
            if (other.contains(curr)) { // TODO is null allowed ?
                return true;
            }
        }

        return false;
    }
}