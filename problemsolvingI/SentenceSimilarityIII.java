
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SentenceSimilarityIII {
    public static boolean areSentencesSimilar(String s1, String s2) {
        // Split the words in sentences and store it in a string array.
        String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
        int start = 0, ends1 = s1Words.length - 1, ends2 = s2Words.length - 1, s1WordsLength = s1Words.length,
                s2WordsLength = s2Words.length;

        // If words in s1 are more than s2, swap them and return the answer.
        if (s1WordsLength > s2WordsLength) {
            return areSentencesSimilar(s2, s1);
        }

        // Find the maximum words matching from the beginning.
        while (start < s1WordsLength && s1Words[start].equals(s2Words[start])) {
            ++start;
        }
        // Find the maximum words matching in the end.
        while (ends1 >= 0 && s1Words[ends1].equals(s2Words[ends2])) {
            --ends1;
            --ends2;
        }

        // If i reaches the end of the array, then we return true.
        return ends1 < start;
    }

    public static boolean areSentencesSimilar2(String s1, String s2) {
        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        // Compare the prefixes or beginning of the strings.
        while (!deque1.isEmpty() &&
                !deque2.isEmpty() &&
                deque1.peek().equals(deque2.peek())) {
            deque1.poll();
            deque2.poll();
        }
        // Compare the suffixes or ending of the strings.
        while (!deque1.isEmpty() &&
                !deque2.isEmpty() &&
                deque1.peekLast().equals(deque2.peekLast())) {
            deque1.pollLast();
            deque2.pollLast();
        }
        return deque1.isEmpty() || deque2.isEmpty();
    }

    public boolean areSentencesSimilar3(String sent1, String sent2) {
        String first = sent1;
        String sec = sent2;
        if (first.length() == sec.length()) {
            return first.equals(sec);
        }
        if (sent2.length() < first.length()) {
            first = sent2;
            sec = sent1;
        }
        int i = -1;
        while (i + 1 < first.length() && first.charAt(i + 1) == sec.charAt(i + 1)) {
            i++;
        }
        int j = first.length();
        int last = sec.length();
        while (j - 1 >= 0 && first.charAt(j - 1) == sec.charAt(last - 1)) {
            j--;
            last--;
        }

        if (i == first.length() - 1 && sec.charAt(i + 1) == ' ') {
            return true;
        }
        if (j == 0 && sec.charAt(last - 1) == ' ') {
            return true;
        }
        if (i + 1 >= j && sec.charAt(i) == ' ' && sec.charAt(last) == ' ') {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
    }
}
