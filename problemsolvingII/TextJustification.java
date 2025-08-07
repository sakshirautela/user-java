import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<ArrayList<String>> row = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();
        int n = words.length;
        getStringPack(words, maxWidth, row, len, n);
        System.out.println(row);
        System.out.println(len);
        List<String> li = new ArrayList<>();
       // addSpace(row, len, maxWidth, li);
        return li;
    }

    private static void addSpace(ArrayList<StringBuilder> row, ArrayList<Integer> len, int maxWidth, List<String> li) {
        int s = row.size() - 1;
        String filler = " ";
        for (int i = 0; i < s; i++) {
            if(len.get(i)==maxWidth){
                continue;
            }
        }
    }

    private static void getStringPack(String[] words, int maxWidth, ArrayList<ArrayList<String>> row, ArrayList<Integer> len, int n) {
        int l = 0;
        int idx = 0;
        row.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int length = words[i].length()+1;
            if (l + length <= maxWidth+1) {
                l += length ;
                row.get(idx).add(words[i]);
            } else {
                len.add(l - 1);
                //row.get(idx).deleteCharAt(row.get(idx).length()-1);
                idx++;
                row.add(new ArrayList<>());
                l = length;
                row.get(idx).add(words[i]);
            }
        }
        if (l > 0) {
            len.add(l - 1);
        }
    }
}
