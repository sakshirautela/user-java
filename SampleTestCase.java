import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SampleTestCase {
    public static void main(String[] args) {
        int[] cookies = { 1, 8, 16, 5, 6, 14 };
        System.out.println(distributeCookies(cookies, 6));
    }

    public static int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        int n = cookies.length;
        for (int i = 0; i < cookies.length / 2; i++) {
            int temp = cookies[i];
            cookies[i] = cookies[cookies.length - 1 - i];
            cookies[cookies.length - 1 - i] = temp;
        }
        HashMap<Integer, Integer> rest = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < cookies.length; i++) {
            sum += cookies[i];
        }
        if (sum == 0) {
            return sum;
        } else {
            int per = sum / k + sum % k;
            System.out.println(sum % k);           
            System.out.println(sum / k);
             System.out.println(per);

            while (k > 1) {
                int perChild = per;
                for (int i = 0; i < n; i++) {
                    if (cookies[i] <= perChild && !rest.containsKey(i)) {
                        perChild -= cookies[i];
                        rest.put(i, cookies[i]);
                    }
                }
                k--;
                temp.add(per - perChild);
            }
        }
        int maxCandy = Integer.MIN_VALUE;
        int a = 0;
        for (int i = 0; i < temp.size(); i++) {
            maxCandy = Math.max(maxCandy, temp.get(i));
        }
        for (int i = 0; i < n; i++) {
            if (!rest.containsKey(i)) {
                a += cookies[i];
            }
        }
        return Math.max(maxCandy, a);
    }
}
