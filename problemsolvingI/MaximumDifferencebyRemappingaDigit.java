
public class MaximumDifferencebyRemappingaDigit {
    public static int minMaxDifference(int num) {
        String a = Integer.toString(num);
        String b = Integer.toString(num);
        for (char ch : a.toCharArray()) {
            if (ch != '0') {
                a = a.replace(ch, '0');
                break;
            }
        }
        for (char ch : b.toCharArray()) {
            if (ch != '9') {
                b = b.replace(ch, '9');
                break;
            }
        }
        return Integer.parseInt(b) - Integer.parseInt(a);
    }

    public int minMaxDifference2(int num) {
        int l = (int) (Math.log10(num)) + 1;
        int[] arr = new int[l];
        int i = l - 1;
        while (num != 0) {
            arr[i] = num % 10;
            i--;
            num /= 10;
        }
        int max = 0;
        i = 0;
        while (i < l && arr[i] == 9) {
            max *= 10;
            max += arr[i];
            i++;
        }
        int val;
        if (i != l) {
            val = arr[i];
            while (i < l) {
                int h = arr[i];
                if (arr[i] == val) {
                    h = 9;
                }
                max *= 10;
                max += h;
                i++;
            }
        }
        val = arr[0];
        int min = 0;
        i = 0;
        while (i < l) {
            int h = arr[i];
            if (arr[i] == val) {
                h = 0;
            }
            min *= 10;
            min += h;
            i++;
        }
        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(minMaxDifference(90));
    }
}
