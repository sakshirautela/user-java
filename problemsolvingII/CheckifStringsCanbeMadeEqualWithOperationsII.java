import java.util.ArrayList;
import java.util.HashMap;

public class CheckifStringsCanbeMadeEqualWithOperationsII {
    static void main() {
        System.out.println(checkStringsT("abcdba", "cabdab"));
    }

    public static boolean checkStringsT(String s1, String s2) {
        int n = s1.length();
        int[] ch = new int[52];
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                ch[s2.charAt(i)-'a']--;
                ch[s1.charAt(i)-'a']++;
            }else{
                ch[s1.charAt(i)-'a'+26]++;
                ch[s2.charAt(i)-'a'+26]--;
            }
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0){
                return false;
            }
        }
        return true;
    }
        public static boolean checkStrings(String s1, String s2) {
        HashMap<Character, Integer> even = new HashMap<>();
        HashMap<Character, Integer> odd = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.put(s1.charAt(i), even.getOrDefault(s1.charAt(i), 0) + 1);
            } else {
                odd.put(s1.charAt(i), odd.getOrDefault(s1.charAt(i), 0) + 1);
            }
        }
        System.out.println(even);
        System.out.println(odd);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (even.getOrDefault(s2.charAt(i), 0) >= 1) {
                    even.put(s2.charAt(i), even.getOrDefault(s2.charAt(i), 0) - 1);
                    if (even.getOrDefault(s2.charAt(i), 0) == 0) {
                        even.remove(s2.charAt(i));
                    }
                } else {
                    return false;
                }
            } else {
                if (odd.getOrDefault(s2.charAt(i), 0) >= 1) {
                    odd.put(s2.charAt(i), odd.getOrDefault(s2.charAt(i), 0) - 1);
                    if (odd.getOrDefault(s2.charAt(i), 0) == 0) {
                        odd.remove(s2.charAt(i));
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}