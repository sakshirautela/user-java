package com.learn.java.problemsolving;

public class CheckifOneStringSwapCanMakeStringsEqual {
    public static void main(String arhs[]) {
        System.out.println(areAlmostEqual1("", ""));
    }

    public static boolean areAlmostEqual1(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 2) {
                return false;
            }
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    /*
     * public String fun(String s2, int idx, int r) {
     * char[] arr = s2.toCharArray();
     * char temp = arr[idx];
     * arr[idx] = arr[r];
     * arr[r] = temp;
     * return new String(arr);
     * }
     */

    public boolean areAlmostEqual(String s1, String s2) {
        /*
         * int n1 = s1.length();
         * int n2 = s2.length();
         * if (n1 != n2) return false;
         * HashMap<Character, Integer> hm = new HashMap<>();
         * for (int i = 0; i < n1; i++) {
         * char ch = s1.charAt(i);
         * if (!hm.containsKey(ch)) {
         * hm.put(ch, i);
         * }
         * }
         * 
         * int l = 0, r = 0;
         * while (l < n1 && r < n2) {
         * char ch1 = s1.charAt(l);
         * char ch2 = s2.charAt(r);
         * if (ch1 != ch2) {
         * int idx = hm.getOrDefault(ch2, -1);
         * if (idx == -1) return false;
         * s2 = fun(s2, idx, r);
         * if (!s1.equals(s2)) {
         * return false;
         * }
         * }
         * l++;
         * r++;
         * }
         * return true;
         */
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2)
            return false;
        if (s1.equals(s2))
            return true;
        int i = 0;
        int j = 0;
        int alag = 0;
        for (int k = 0; k < n1; k++) {
            char ch1 = s1.charAt(k);
            char ch2 = s2.charAt(k);
            if (ch1 != ch2) {
                alag++;
                if (alag > 2)
                    return false;
                else if (alag == 1) {
                    i = k;
                } else {
                    j = k;
                }
            }
        }
        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i))
            return true;

        else
            return false;

    }
    /*
     * we are only allowed one swap --> if more than two char unequal return fasle;
     * bank
     */
}