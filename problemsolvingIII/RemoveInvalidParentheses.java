package problemsolvingIII;

import java.util.*;

public class RemoveInvalidParentheses {
    static void main() {
        System.out.println(validParenthesis("()())()"));
//        System.out.println(isValid("())".toCharArray()));
    }

    public static List<String> validParenthesisQueue(String s) {
        int n = s.length();
        Queue<String> q = new LinkedList<>();
        List<String> res = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        return res;

    }
        public static List<String> validParenthesis(String s) {
        int left = 0;
        int right = 0;
        Set<String> result = new HashSet<>();
        int minRemovals;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        minRemovals = left + right;

        dfs(s, 0, 0, 0, "", result, minRemovals);

        return new ArrayList<>(result);
    }

    private static void dfs(String s, int index, int open, int close, String current, Set<String> result, int minRemovals) {
        if (close > open) {
            return;
        }
        if(open>(s.length()-minRemovals)/2){
            return;
        }
        if (index == s.length()) {
            if (open == close && minRemovals == 0) {
                result.add(current);
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            if (minRemovals > 0) {
                minRemovals--;
                dfs(s, index + 1, open, close, current, result, minRemovals);
                minRemovals++;
            }
            dfs(s, index + 1, open + 1, close, current + "(", result, minRemovals);
        } else if (c == ')') {
            if (minRemovals > 0) {
                minRemovals--;
                dfs(s, index + 1, open, close, current, result, minRemovals);
                minRemovals++;
            }
            if (close < open) {
                dfs(s, index + 1, open, close + 1, current + ")", result, minRemovals);
            }
        } else {
            dfs(s, index + 1, open, close, current + c, result, minRemovals);
        }
    }
}
