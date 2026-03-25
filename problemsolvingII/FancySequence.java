import java.util.ArrayList;

public class FancySequence {
    static void main() {
        FancySequence fs = null;
        String[] commands = {"Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"};
        int[][] values = {
                {},
                {2},
                {3},
                {7},
                {2},
                {0},
                {3},
                {10},
                {2},
                {0},
                {1},
                {2}
        };
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {

                case "Fancy":
                    fs = new FancySequence();
                    break;

                case "append":
                    fs.append(values[i][0]);
                    break;

                case "addAll":
                    fs.addAll(values[i][0]);
                    break;

                case "multAll":
                    fs.multAll(values[i][0]);
                    break;

                case "getIndex":
                    System.out.println(fs.getIndex(values[i][0]));
                    break;
            }
        }
        System.out.println(fs.arr);

    }

    ArrayList<Long> arr;
    long mul = 1;
    long add = 0;
    long mod = 1000000007;

    public FancySequence() {
        arr = new ArrayList<>();
    }

    public void append(int val) {
        long v = (val - add + mod) % mod;
        v = (v * modInverse(mul)) % mod;
        arr.add(v);
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;

        long val = arr.get(idx);
        val = (val * mul % mod + add) % mod;

        return (int) val;
    }

    private long modInverse(long x) {
        return pow(x, mod - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */