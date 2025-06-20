
public class SwapAdjacentinLRString {
    public static void main(String[] args) {
        System.out.println(canTransform("RXXLRXRXL","XRLXXRRLX"));
    }
    static {
        for(int i=0;i<500;i++){
            canTransform("","");
        }
    }
    public static boolean canTransform2(String start, String result) {
        if (start.length() != result.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            // Skip 'X' in start
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            // Skip 'X' in result
            while (j < n && result.charAt(j) == 'X') {
                j++;
            }

            // Check if both strings are exhausted
            if (i == n && j == n) {
                return true;
            }
            // If one is exhausted before the other
            if (i == n || j == n) {
                return false;
            }

            char s = start.charAt(i);
            char r = result.charAt(j);
            if (s != r) {
                return false;
            }
            if (s == 'L' && i < j) {
                return false; // 'L' cannot move right
            }
            if (s == 'R' && i > j) {
                return false; // 'R' cannot move left
            }

            i++;
            j++;
        }

        return true;
    }
    public static boolean canTransform(String start, String result) {
        
        int i = 0;
        int j = 0;
        char[] s = start.toCharArray();
        char[] r = result.toCharArray();
        
        while (i < s.length || j < r.length)
        {
            // stop at char that is not 'X'
            while (i < s.length && s[i] == 'X') { i++; }
            while (j < r.length && r[j] == 'X') { j++; }
            
            if (i >= s.length || j >= r.length) { break; }
            // relative order for 'R' and 'L' in 2 strings should be the same
            if (s[i] != r[j]) { return false; }
            // R can only move to right
            if (s[i] == 'R' && i > j) { return false; }
            // L can only move to left
            if (s[i] == 'L' && i < j) { return false; }
            
            // check next
            i++;
            j++;
        }
        
        return i == j;
    }
}