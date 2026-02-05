public class MinimumPenaltyForaSoup {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YNYY"));
    }

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int available = 0;
        for (char ch : customers.toCharArray()) {
            if (ch == 'Y') {
                available++;
            }
        }
        int result = 0;
        int diff = available;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                available--;
            } else {
                available++;
            }
            if (diff > available) {
                diff = available;
                result = i + 1;
            }
        }
        return result;
    }
    public int bestClosingTimeFast(String customers) {
       // byte[] cs = customers.getBytes(java.nio.charset.Charset.forName("ISO-8859-1"));

        byte cs[]=new byte[10000];
        int bestTime = -1;
        int customersLeft = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 89) {
                customersLeft++;
                if (customersLeft > 0) {
                    bestTime = i;
                    customersLeft = 0;
                }
            } else {
                customersLeft--;
            }
        }

        return bestTime+1;
    }
}
