import java.util.Stack;

public class UsingaRobottoPrinttheLexicographicallySmallestString {
    public static void main(String[] args) {
        System.out.println(robotWithString("zza"));
    }

    public static String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minCharacter = 'a';
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            while (minCharacter != 'z' && freq[minCharacter - 'a'] == 0) {
                minCharacter++;
            }
            while (!stack.isEmpty() && stack.peek() <= minCharacter) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
    public String robotWithString2(String s) {
        int[] freq = new int[26];
        int  i = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        while (i < 26 && freq[i] == 0) {
            i++;
        }

        for (char c : s.toCharArray()) {
            if (c - 'a' == i) {
                sb.append(c);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) {
                    while (i < 26 && freq[i] == 0) {
                        i++;
                    }
                    while (i < 26 && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) <= i + 'a') {
                        sb.append(sb2.charAt(sb2.length() - 1));
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                }
            } else {
                sb2.append(c);
                freq[c - 'a']--;
            }
        }

        sb2.reverse();
        sb.append(sb2);
        return sb.toString();
    }
}