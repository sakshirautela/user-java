package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThekthLexicographicalStringofAllHappyStringsofLengthN {
    public String getHappyString(int n, int k) {
        List<String> sizeN = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.length() == n) {
                sizeN.add(curr);
                continue;
            }
            char lastChar = curr.charAt(curr.length() - 1);
            if (lastChar == 'a') {
                queue.offer(curr + "b");
                queue.offer(curr + "c");
            } else if (lastChar == 'b') {
                queue.offer(curr + "a");
                queue.offer(curr + "c");
            } else {
                queue.offer(curr + "a");
                queue.offer(curr + "b");
            }
        }
        if (sizeN.size() < k) {
            return "";
        } else {
            return sizeN.get(k - 1);
        }

    }

    int n2;

    public String getHappyString2(int n, int k) {
        n2 = n;
        return dfs(new StringBuilder(), n, k);
    }

    public String dfs(StringBuilder prefix, int n, int k) {
        if (n == 0)
            return prefix.toString();
        for (char c = 'a'; c <= 'c'; c++) {
            if (prefix.length() > 0 && c == prefix.charAt(prefix.length() - 1))
                continue;
            int cnt = (int) Math.pow(2, n2 - prefix.length() - 1);
            if (cnt >= k)
                return dfs(prefix.append(c), n - 1, k);
            else
                k -= cnt;
        }
        return "";
    }
}