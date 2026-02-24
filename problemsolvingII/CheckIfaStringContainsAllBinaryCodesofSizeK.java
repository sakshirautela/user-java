import java.util.HashSet;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    static void main() {
        System.out.println(hasAllCodes("00110110", 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < Math.max(0, k - 1); i++) {
            sb.append(s.charAt(i));
        }
        while (i < n) {
            sb.append(s.charAt(i));
            set.add(sb.toString());
            sb.deleteCharAt(0);
            i++;
        }
        //System.out.println(set);
        return set.size() == Math.pow(2, k);
    }

}
