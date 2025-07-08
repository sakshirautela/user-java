public class FindtheKthCharacterinStringGameII {
    public static void main(String[] args) {
        System.out.println(kthCharacter(32576176,
                new int[] { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 }));
    }

    public char kthCharacterFast(long k, int[] operations) {
        int c = 0;
        k--;
        for (int i = 0; k != 0; i++, k >>= 1) {
            c += ((int) (k & 1) & operations[i]);
        }
        return (char) ((c % 26) + 'a');
    }

    public static char kthCharacter(long k, int[] operations) {

        return solve(k, operations, operations.length);
    }

    private static char solve(long k, int[] operations, int n) {
        char result = 'a';

        while (n > 0) {
            long left = 1;
            long right = (long) Math.pow(2, n);
            long mid = left + (right - left) / 2;
            int flip = operations[n - 1];

            if (k <= mid) {
                // go to left half, just reduce n
                n--;
            } else {
                // right half
                k = k - mid;
                if (flip == 1) {
                    // simulate character increment
                    result = result == 'z' ? 'a' : (char) (result + 1);
                }
                n--;
            }
        }

        return result;
    }

    public static char kthCharacterTLE(long k, int[] operations) {
        StringBuilder str = new StringBuilder();
        str.append('a');

        int n = operations.length;
        int i = 0;

        while (i < n && str.length() * 2 < k) {
            int len = str.length();
            if (operations[i] == 0) {
                str.append(str);
            } else {
                for (int j = 0; j < len; j++) {
                    char c = str.charAt(j);
                    if (c == 'z') {
                        str.append('a');
                    } else {
                        str.append((char) (c + 1));
                    }
                }
            }
            i++;
        }
        int l = str.length();
        System.err.println(k - l - 1);
        System.out.println(l);
        int index = (int) (k - l) - 1;
        char result = str.charAt(index);
        if (i < n && operations[i] == 1) {
            result = (result == 'z') ? 'a' : (char) (result + 1);
        }
        return result;
    }
}
