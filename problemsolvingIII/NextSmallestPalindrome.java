package problemsolvingIII;

public class NextSmallestPalindrome {
    static void main() {
        int[] res = nextPalindrome(new int[]{7});
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    static int[] nextPalindrome(int[] num) {
        if(all9s(num)){
            int[] res = new int[num.length+1];
            res[0] = 1;
            return res;
        }
        // code here
        int n = num.length;
        int i = n / 2 - 1;
        int j = n / 2 + n % 2;
        boolean flag = false;
        while (i >=0 && num[i] == num[j]) {
            i--;
            j++;
        }
        if (i < 0 || num[i] < num[j]) {
            flag = true;
        }
        int op = (n%2==0?n / 2-1 : n/2) ;
        int rem = 1;
        if (flag) {
            while (op >= 0 && rem > 0) {
                int digit = num[op];
                num[op] = (digit + rem) % 10;
                rem = (digit + rem) / 10;
                op--;
            }
        }

        i = 0;
        j = n - 1;
        while (i < j) {
            num[j] = num[i];
            i++;
            j--;
        }
        return num;
    }

    private static boolean all9s(int[] num) {
        for (int i : num) {
            if (i != 9) {
                return false;
            }
        }
        return true;
    }
}
