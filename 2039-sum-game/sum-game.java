class Solution {
    public boolean sumGame(String num) {
         int sum = 0;
        int chances = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                if (i < num.length() / 2) {
                    chances++;
                } else {
                    chances--;
                }
            } else {
                if (i < num.length() / 2) {
                    sum += num.charAt(i) - '0';
                } else {
                    sum -= num.charAt(i) - '0';
                }
            }
        }

        return 2 * sum + 9 * chances != 0;
    }
}