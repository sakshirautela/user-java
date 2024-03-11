import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class CountWords {
    public static int countWords(String[] words1, String[] words2) {
        ArrayList<String> w = new ArrayList<String>();
        ArrayList<String> c = new ArrayList<String>();
        for (String word : words1) {
            w.add(word);
        }
        for (String word : words2) {
            c.add(word);
        }
        int count = 0;
        for (String word : words2) {
            if(Collections.frequency(c,word)==1 && Collections.frequency(w,word)==1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] words1={"a","ab"};        
        String[] words2={"a","a","a","a","ab"};
        System.out.println(countWords(words1,words2));

    }
}