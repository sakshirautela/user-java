public class CounttheNumberofPowerfulIntegers {
    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(5,3,2,""));
    }
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String start_ = Long.toString(start - 1);
        String finish_ = Long.toString(finish);
        return calculate(finish_, s, limit) - calculate(start_, s, limit);
    }

    private static
     long calculate(String x, String s, int limit) {
        if (x.length() < s.length()) {
            return 0;
        }
        if (x.length() == s.length()) {
            return x.compareTo(s) >= 0 ? 1 : 0;
        }

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count +=
                (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) {
            count++;
        }
        return count;
    }
    public long numberOfPowerfulInt2(long start, long finish, int limit, String s) {
        long suffix = 0L;
        for (char c : s.toCharArray())
            suffix = suffix * 10 + c - '0';
        if (suffix > finish)
            return 0;
        long div = (long) Math.pow(10, s.length()), ps = start / div, pf = finish / div;
        if (finish % div >= suffix)
            pf++;
        if (start % div > suffix)
            ps++;
        return getAvailNum(pf, limit) - getAvailNum(ps, limit);
    }

    private long getAvailNum(long num, long limit) {
        if (num == 0)
            return 0;
        if (limit == 9)
            return num;
        int digits = (int) Math.log10(num);
        long div = (long) Math.pow(10, digits), res = 0L;
        for (int i = digits; i >= 0; i--) {
            int d = (int) (num / div);
            if (d > limit)
                return res + (long) Math.pow(limit + 1, i + 1);
            else
                res += d * (long) Math.pow(limit + 1, i);
            num %= div;
            div /= 10;
        }
        return res;
    }
}