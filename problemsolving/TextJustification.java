import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> li=new ArrayList<>();
        List<String> list=new ArrayList<>();
        List<Integer> count=new ArrayList<>(words.length);
        int size=-1;
        int c=0;
        li.add(new ArrayList<String>());
        int idx=0;
        for (String w : words) {
            int s=w.length()+1;
            if(size+s>maxWidth){
                size=s-1;
                count.add(c);
                c=size;
                li.add(new ArrayList<String>());
                idx++;
                li.get(idx).add(w);
            }else{
                c+=s-1;
                li.get(idx).add(w);
                size+=s;
            }
        }
        count.add(c);
        for (int i = 0; i < li.size(); i++) {
            int target=maxWidth-count.get(i);
            int len=li.get(i).size();
            int gap=(len>0)?(target/len):target;
            StringBuilder sb=new StringBuilder();
            for(String s:li.get(i)){
                sb.append(s+gapAdd(gap,target));
                target-=gap;
            }
            list.add(sb.toString());
        }
        return list;
    }
    private static String gapAdd(int gap,int target) {
        StringBuilder sb=new StringBuilder();
        while (target>=gap && gap>0) {
            sb.append(" ");
            gap--;
        }
        return sb.toString();
    }
}