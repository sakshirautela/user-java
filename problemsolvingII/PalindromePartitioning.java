import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getpartitions(s, 0, res, new ArrayList<>(), s.length());
        return res;
    }

    private static void getpartitions(String s, int i, List<List<String>> res, ArrayList<String> li, int n) {
        if (i == n) {
            res.add(new ArrayList<>(li));
        }
        for (int j = i + 1; j <= n; j++) {
            String sub = s.substring(i, j);
            if (ispalindrome(sub, j - i - 1)) {
                li.add(sub);
                getpartitions(s, j, res, li, n);
                li.removeLast();
            }
        }
    }

    private static boolean ispalindrome(String sub, int l) {
        int i = 0;
        while (i < l) {
            if (sub.charAt(i) != sub.charAt(l)) {
                return false;
            }
            i++;
            l--;
        }
        return true;
    }

//    public List<List<String>> partition2(String s) {
//        return new java.util.AbstractList() {
//            List<List<String>> result;
//
//            private void init() {
//                result = new ArrayList();
//                backtrack(0, s, new ArrayList(), result);
//            }
//
//            @Override
//            public int size() {
//                if (result == null) {
//                    init();
//                }
//                return result.size();
//            }
//
//            @Override
//            public List<String> get(int position) {
//                return result.get(position);
//            }
//        };
//    }
//
//    private void backtrack(int index, String s, List<String> list, List<List<String>> result) {
//        if (index == s.length()) {
//            // for(String item : list){
//            //     if(!isPalindrome(item)){
//            //         return;
//            //     }
//            // }
//            result.add(new ArrayList(list));
//            return;
//        }
//        for (int i = index; i < s.length(); i++) {
//            String st = s.substring(index, i + 1);
//            if (isPalindrome(st)) {
//                list.add(st);
//                backtrack(i + 1, s, list, result);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//
//    private boolean isPalindrome(String s) {
//        int low = 0;
//        int high = s.length() - 1;
//        while (low <= high) {
//            if (s.charAt(low) != s.charAt(high)) {
//                return false;
//            }
//            low++;
//            high--;
//        }
//        return true;
//    }
}