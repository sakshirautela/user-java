class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26]; 
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++; 
        }
        return dfs(freq);
    }

    private int dfs(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--; 
                count += 1 + dfs(freq); 
                freq[i]++; 
            }
        }
        return count;
    }
}