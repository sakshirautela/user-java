import java.util.HashSet;
import java.util.List;

public class FindUniqueBinaryString {
    static void main() {
        System.out.println(findDifferentBinaryString(new String[]{"01","10"}));
    }
    public String findDifferentBinaryStringLogic(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        String[] res={""};
        HashSet<String> set = new HashSet<>(List.of(nums));
        findDifferentBinaryStringHelper(set, res, n, 0,"");
        return res[0];
    }

    private static void findDifferentBinaryStringHelper(HashSet<String> set, String[] s, int n, int i,String p) {
        if (i == n) {
            if (!set.contains(p)){
                s[0]=p;
            }
            return ;
        }
        findDifferentBinaryStringHelper(set, s, n, i+1, p+"0");
        findDifferentBinaryStringHelper(set, s, n, i+1, p+"1");
    }
}