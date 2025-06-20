
public class TakeKofEachCharacterFromLeftandRight {
    public static int takeCharacters(String s, int k) {
        int[] count = new int[3];
        int n = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        if (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
            return -1;
        }

        // Sliding Window
        int res = n + 1;
        int l = 0;
        for (int r = 0; r < n; r++) {
            count[s.charAt(r) - 'a']--;
            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, n - (r - l + 1));
        }
        return res;
    }

    public int takeCharacters2(String s, int k) {
        int[] arr = new int[3];
        char[] c = s.toCharArray();
        int cur, len = c.length;
        for (cur = 0; cur < len; cur++) {
            arr[c[cur] - 'a']++;
            if (arr[0] >= k && arr[1] >= k && arr[2] >= k)
                break;
        }
        if (cur == len)
            return -1;
        int count = cur + 1, min = count, end = len - 1;
        while (cur >= 0) {
            if (arr[c[cur] - 'a'] == k) {
                while (c[cur] != c[end]) {
                    arr[c[end] - 'a']++;
                    end--;
                    count++;
                }
                end--;
            } else {
                arr[c[cur] - 'a']--;
                count--;
                min = Math.min(count, min);
            }
            cur--;
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }
}
