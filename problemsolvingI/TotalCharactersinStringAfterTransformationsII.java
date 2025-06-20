import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalCharactersinStringAfterTransformationsII {
    public int lengthAfterTransformations4(String s, int t, List<Integer> nums) {
        /*
        observation: 
        since the only thing that matters is the length of the string after transformations and 
        the transformations impact each individual character of the current s state independently and the position/order
        does not impact the transformation, only the letters, the order of s is irrelevant, only need to pay attention to the counts of every letter. 

        can reduce s to a sz 26 vector counting freq of every letter in s.
        Instead of transforming s, can transform vector counts.

        have oldCnt and newCnt vectors for before and after transform
        newCnt[i] = [sum over all k < 26 where nums[i-k] >= k (including wrap around mod k) of oldCnt[i-k]]

        such a transformation seems linear and seems like we can construct a matrix to do through matrix mult
        matrix mult is equiv to multiplying each col of matrix by old vector cooresponding so can construct matrix by filling each 
        index's cooresponding value column with ones from row (i+1) % 26 to (i+nums[i]) % 26

        using such a matrix A can mult A*old = new
        thus have A^t * old = new_t_transformed.

        So problem is reduced to matrix exponentiation of A^t
        */
        int[] cnt = getLetterCounts(s);
        int[][] transformMatrix = createTransformMatrix(nums);
        //for(long[] row : transformMatrix) System.out.println(Arrays.toString(row));
        //System.out.println("post pow");
        //for(long[] row : transformMatrix) System.out.println(Arrays.toString(row));

        int[] transformedCnt = matrixExp(transformMatrix, cnt, t);
        long res = 0;
        for(int freq : transformedCnt) res += freq; //dont need to mod each individually as already modded in ops so will be at most 26*mod when summed, which doesn't overflow long, so can mod at end
        return (int)(res % MOD);

    }

    private int[] getLetterCounts(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) cnt[s.charAt(i)-'a']++;
        return cnt;
    }
    private int[][] createTransformMatrix(List<Integer> nums) {
        int[][] A = new int[26][26];
        for(int i = 0; i < 26; i++) {
            int lim = i + nums.get(i);
            for(int j = i+1; j <= lim; j++) {
                A[j % 26][i] = 1;
            }
        }
        return A;
    }
    private int[] matrixVectorMult(int[][] A, int[] x) {
        int[] y = new int[26];
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                y[i] = (int)((y[i] + 1L*A[i][j]*x[j]) % MOD);
            }
        }
        return y;
    }

private int[][] matrixSq(int[][] A) {
    int[][] C   = new int[26][26];
    long[] acc  = new long[26];

    for (int i = 0; i < 26; i++) {
        // 1) zero out our accumulator for row i
        Arrays.fill(acc, 0L);

        // 2) do the full A[i]·A multiplication into acc[j]
        for (int k = 0; k < 26; k++) {
            int aik = A[i][k];
            if (aik == 0) continue;          // skip zeros entirely

            int[] Ak = A[k];
            for (int j = 0; j < 26; j++) {
                acc[j] += (long)aik * Ak[j];
            }

            // 3) every 4 k’s, flush acc[j] down to < MOD
            if ((k & 3) == 3) {
                for (int j = 0; j < 26; j++) {
                    acc[j] %= MOD;
                }
            }
        }

        // 4) final reduction & write into C
        for (int j = 0; j < 26; j++) {
            C[i][j] = (int)(acc[j] % MOD);
        }
    }

    return C;
}


    private int[] matrixExp(int[][] matrix, int[] vector, int exp) {
        int[][] sq = copy(matrix);
        while(exp > 0) {
            if((exp & 1) == 1) vector = matrixVectorMult(sq, vector);
            sq = matrixSq(sq);
            exp >>= 1;
        }
        return vector;
    }

    private int[][] copy(int[][] matrix) {
        int[][] c = new int[26][26];
        for(int i = 0; i < 26; i++) c[i] = matrix[i].clone();
        return c;
    }

    @SuppressWarnings("unused")
    private int[][] identity() {
        int[][] iden = new int[26][26];
        for(int i = 0; i < 26; i++) iden[i][i] = 1;
        return iden;
    }
    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("abcyy",2,new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2))));
    }

    private static final int MOD = (int) 1e9 + 7;
    private static final int L = 26;

    private static class Mat {

        int[][] a = new int[L][L];

        Mat() {}

        Mat(Mat copyFrom) {
            for (int i = 0; i < L; i++) {
                System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
            }
        }

        Mat mul(Mat other) {
            Mat result = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    for (int k = 0; k < L; k++) {
                        result.a[i][j] = (int) ((result.a[i][j] +
                                (long) this.a[i][k] * other.a[k][j]) %
                            MOD);
                    }
                }
            }
            return result;
        }
    }

    /* identity matrix */
    private Mat I() {
        Mat m = new Mat();
        for (int i = 0; i < L; i++) {
            m.a[i][i] = 1;
        }
        return m;
    }

    /* matrix exponentiation by squaring */
    private Mat quickmul(Mat x, int y) {
        Mat ans = I();
        Mat cur = new Mat(x);
        while (y > 0) {
            if ((y & 1) == 1) {
                ans = ans.mul(cur);
            }
            cur = cur.mul(cur);
            y >>= 1;
        }
        return ans;
    }

    public int lengthAfterTransformations2(String s, int t, List<Integer> nums) {
        Mat T = new Mat();
        for (int i = 0; i < L; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                T.a[(i + j) % L][i] = 1;
            }
        }

        Mat res = quickmul(T, t);
        int[] f = new int[L];
        for (char ch : s.toCharArray()) {
            f[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                ans = (int) ((ans + (long) res.a[i][j] * f[j]) % MOD);
            }
        }
        return ans;
    }
    static int mod=100000007;
    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] T = getTransformationMatrix(nums);
        int[][] poweredT = matrixPow(T, t);
        int[] count = new int[26];
        int[] lengths = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                lengths[j] = (int)((lengths[j] + 1L * count[i] * poweredT[i][j]) % MOD);
            }
        }

        int total = 0;
        for (int len : lengths) {
            total = (total + len) % MOD;
        }

        return total;
    }

    private static int[][] getTransformationMatrix(List<Integer> nums) {
        int[][] T = new int[26][26];
        for (int i = 0; i < nums.size(); i++) {
            for (int step = 1; step <= nums.get(i); step++) {
                T[i][(i + step) % 26]++;
            }
        }
        return T;
    }

    private static int[][] getIdentityMatrix(int size) {
        int[][] I = new int[size][size];
        for (int i = 0; i < size; i++) {
            I[i][i] = 1;
        }
        return I;
    }

    private static int[][] matrixMult(int[][] A, int[][] B) {
        int size = A.length;
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                long sum = 0;
                for (int k = 0; k < size; k++) {
                    sum = (sum + 1L * A[i][k] * B[k][j]) % MOD;
                }
                C[i][j] = (int)sum;
            }
        }
        return C;
    }

    private static int[][] matrixPow(int[][] M, int n) {
        if (n == 0) return getIdentityMatrix(M.length);
        if (n % 2 == 1) return matrixMult(M, matrixPow(M, n - 1));
        int[][] half = matrixPow(M, n / 2);
        return matrixMult(half, half);
    }
}