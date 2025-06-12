import java.util.Arrays;

public class MaximumDifferenceBetweenEvenandOddFrequencyII {
    public static void main(String[] args) {
        System.out.println(maxDifference("", 4));
    }

    /*
     * Copyright (c) 2025 by https://leetcode.com/u/brinuke/. All rights reserved.
     */
    private static final int BAD_DIFF = Integer.MAX_VALUE / 2;

    public static int maxDifference2(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] mpdAB = new int[4]; // min prefix diff freq(a) - freq(b)
        int[] mpdBA = new int[4]; // min prefix diff freq(b) - freq(a)
        boolean[] isAbsent = new boolean[5];
        int result = Integer.MIN_VALUE;
        aCharLoop: for (char a = '1'; a <= '4'; a++)
            bCharLoop: for (char b = '0'; b < a; b++) {
                if (isAbsent[b - '0'])
                    continue;
                int right = 0;
                int arf = 0;
                int brf = 0;
                // Initialize the window moving its right side
                while (right < k || arf + brf < 3 || arf == 0 || brf == 0) {
                    if (right == n) {
                        if (brf == 0)
                            isAbsent[b - '0'] = true;
                        if (arf == 0) {
                            isAbsent[a - '0'] = true;
                            continue aCharLoop;
                        } else
                            continue bCharLoop;
                    }
                    char c = chars[right++];
                    if (c == a)
                        arf++;
                    else if (c == b)
                        brf++;
                }
                int left = 0;
                int alf = 0;
                int blf = 0;
                Arrays.fill(mpdAB, BAD_DIFF);
                Arrays.fill(mpdBA, BAD_DIFF);
                mpdAB[0] = mpdBA[0] = 0;
                while (true) {
                    int parityState, freqDiff;
                    // Move left side
                    while (left < right - k) {
                        char c = chars[left++];
                        if (c == a) {
                            if (arf == alf + 1) { // no a would remain in the window
                                left--;
                                break;
                            }
                            alf++;
                        } else if (c == b) {
                            if (brf == blf + 1) { // no b would remain in the window
                                left--;
                                break;
                            }
                            blf++;
                        } else
                            continue;
                        parityState = ((alf & 1) << 1) + (blf & 1);
                        freqDiff = alf - blf;
                        mpdAB[parityState] = Math.min(mpdAB[parityState], freqDiff);
                        mpdBA[parityState] = Math.min(mpdBA[parityState], -freqDiff);
                    }
                    // Update main result
                    parityState = ((arf & 1) << 1) + (brf & 1);
                    freqDiff = arf - brf;
                    result = Math.max(result, freqDiff - mpdAB[parityState ^ 2]); // a odd, b even
                    result = Math.max(result, -freqDiff - mpdBA[parityState ^ 1]); // b odd, a even
                    if (right == n)
                        break;
                    // Move right side
                    char c = chars[right++];
                    if (c == a)
                        arf++;
                    else if (c == b)
                        brf++;
                    else
                        while (right < n && (c = chars[right]) != a && c != b)
                            right++;
                }
            }
        return result;
    }

    private final static int INF = Integer.MAX_VALUE/2;

    public int maxDifference3(String s, int k) {
        int n = s.length();
        int[][] preFreq = new int[n+1][5]; // preFreq[i][c] - frequency of character c in s[0, i)
        for(int i=1; i<=n; i++){
            for(int c=0; c<5; c++){
                preFreq[i][c] = preFreq[i-1][c];
            }
            preFreq[i][s.charAt(i-1)-'0']++;
        }

        int ans = -INF;
        for(int a=0; a<5; a++){ // character that has an odd frequency in subs
            for(int b=0; b<5; b++){ // character that has an even frequency in subs
                if(a==b){
                    continue;
                }

                ans = Math.max(ans, maxDifference4(a, b, s, k, preFreq));
            }
        }

        return ans;
    }

    // maximum preFreq[j][a] - preFreq[i][a] - (preFreq[j][b] - preFreq[i][b])
    private int maxDifference4(int a, int b, String s, int k, int[][] preFreq){
        int res = -INF;
        // minPreFreq[x][y] - minimum preFreq[a]-preFreq[b] when preFreq[a]%2==x and preFreq[b]%2==y
        int[][] minPreFreq = {{INF, INF},{INF, INF}};
        for(int i=0, j=1; j<=s.length(); j++){
            int ra = preFreq[j][a], rb = preFreq[j][b];
            while(j-i>=k && ra != preFreq[i][a] && rb != preFreq[i][b]){
                int la = preFreq[i][a], lb = preFreq[i][b];
                minPreFreq[la&1][lb&1] = Math.min(minPreFreq[la&1][lb&1], la-lb);
                i++;
            }
            res = Math.max(res, ra - rb - minPreFreq[ra&1^1][rb&1]);
        }
        
        return res;
    }
    public static int maxDifference(String s, int k) {
        int n=s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; ++right) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int left_status = getStatus(prev_a, prev_b);
                        best[left_status] = Math.min(
                            best[left_status],
                            prev_a - prev_b
                        );
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int right_status = getStatus(cnt_a, cnt_b);
                    if (best[right_status ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(
                            ans,
                            cnt_a - cnt_b - best[right_status ^ 0b10]
                        );
                    }
                }
            }
        }
        return ans;
    }

    private static int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}