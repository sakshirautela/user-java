public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstr(""));
    }
    static int maxChar=26;
    public static int longestUniqueSubstr(String s) {
        // code here
        int n=s.length();
        int result=0;
        for (int i = 0; i < n; i++) {
            boolean[] visited=new boolean[maxChar];
            for (int j = i; j <n; j++) {
                if(visited[s.charAt(j)-'a']){
                    break;
                }else{
                    result=Math.max(result, j-i+1);
                    visited[s.charAt(j)-'a']=true;
                }
            }
        }
        return result;
    }
    static int longestUniqueSubstr2(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();

        int res = 0;
        boolean[] vis = new boolean[maxChar];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If character is repeated, move left pointer marking
            // visited characters as false until the repeating 
            // character is no longer part of the current window
            while (vis[s.charAt(right) - 'a'] == true) {
                vis[s.charAt(left) - 'a'] = false;
                left++;
            }

            vis[s.charAt(right) - 'a'] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly.
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }
}