public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R')
                force = N;
            else if (A[i] == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L')
                force = N;
            else if (A[i] == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f : forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }

    public String pushDominoes2(String dominoes) {
        int n = dominoes.length();
        char ch[] = dominoes.toCharArray();
        int i = 0;
        while (i < n) {
            if (ch[i] != '.') {
                i++;
                continue;
            }
            int j = i;
            while (j < n && ch[j] == '.')
                j++;
            if (i - 1 >= 0 && j < n) {
                if (ch[i - 1] == ch[j]) {
                    int k = i;
                    while (k < j)
                        ch[k++] = ch[i - 1];
                } else {
                    if (ch[i - 1] == 'R') {
                        int u = i, v = j - 1;
                        while (u < v) {
                            ch[u++] = 'R';
                            ch[v--] = 'L';
                        }
                    }
                }
            } else if (i - 1 >= 0) {
                if (ch[i - 1] == 'R') {
                    int k = i;
                    while (k < j)
                        ch[k++] = 'R';
                }
            } else if (j < n) {
                if (ch[j] == 'L') {
                    int k = i;
                    while (k < j)
                        ch[k++] = 'L';
                }
            }
            i = j;
        }
        return String.valueOf(ch);
    }
}