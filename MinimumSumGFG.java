import java.util.Arrays;

public class MinimumSumGFG {
    static String minSum(int[] arr) {
        // code here
        Arrays.sort(arr);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < arr.length; i += 2) {
            s1.append(arr[i]);
        }
        for (int i = 1; i < arr.length; i += 2) {
            s2.append(arr[i]);
        }

        return addString(s1.toString(), s2.toString());
    }

    static String addString(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = (s1.charAt(i) - '0') +
                    (s2.charAt(j) - '0') + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (i == 0) {
            int sum = (s1.charAt(i) - '0') + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            res.append(carry);
        }
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0')
            res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }

    public static void main(String args[]) {
        System.out.print(minSum(new int[] { 16, 17, 71, 62, 12, 24, 14 }));
    }
}
