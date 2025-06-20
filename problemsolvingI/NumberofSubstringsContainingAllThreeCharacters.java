
public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcc"));
    }

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int result = 0;
        int l = 0, r = 0;
        int[] freq = new int[3];
        while (r < n) {
            char ch = s.charAt(r);
            freq[ch - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                result += n - r;
                char c = s.charAt(l);
                freq[c - 'a']--;
                l++;
            }
            r++;
        }
        return result;
    }
    public int numberOfSubstrings2(String s) {
        char[] ch = s.toCharArray();
        int[] abc = new int[3];
        for (int i = 0; i < abc.length; i++) {
            abc[i] = -1;
        }
        int count = 0, right = 0;
        while (right < ch.length) {
            abc[ch[right] - 'a'] = right;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, abc[i]);
            }
            count += (min + 1);
            right++;
        }
        return count;
    }
}
