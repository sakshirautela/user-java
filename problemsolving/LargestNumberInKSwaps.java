
public class LargestNumberInKSwaps {
    public static void main(String[] args) {
        System.out.println(findMaximumNum("4551711527", 3));
    }
    static void match(String curr, StringBuilder result) {
        if (curr.compareTo(result.toString()) > 0) {
            result.replace(0, result.length(), curr);
        }
    }
    static void setDigit(StringBuilder s, int index, StringBuilder res, int k) {
        if (k == 0 || index == s.length() - 1) {
            match(s.toString(), res);
            return;
        }

        int maxDigit = 0;
        for (int i = index; i < s.length(); i++) {
            maxDigit = Math.max(maxDigit, s.charAt(i) - '0');
        }
        if (s.charAt(index) - '0' == maxDigit) {
            setDigit(s, index + 1, res, k);
            return;
        }
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' == maxDigit) {
                char temp = s.charAt(index);
                s.setCharAt(index, s.charAt(i));
                s.setCharAt(i, temp);
                setDigit(s, index + 1, res, k - 1);
                s.setCharAt(i, s.charAt(index));
                s.setCharAt(index, temp);
            }
        }
    }
    static String findMaximumNum(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        setDigit(new StringBuilder(s), 0, res, k);
        return res.toString();
    }
    // Function to find the largest number after k swaps.
    public static String findMaximumNumWrong(String s, int k) {
        // code here.
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] a=new int[k];
        for (int i = 0; i < n  && k>0; i++) {
            int curr = arr[i] - '0';
            int idx = -1;
            for (int j = n-1;j>i; j--) {
                int max = arr[j] - '0';
                if (curr < max) {
                    curr = max;
                    idx = j;
                }
            }

            int id=idx;
            for(int ab:a){
                if(arr[ab]-'0'>arr[id]-'0'){
                    id=ab;
                }
            }
            if(id!=-1 && id!=idx){
                char temp = arr[id];
                arr[id] = arr[idx];
                arr[idx] = temp;
            }
            if (idx != -1 && k>0) {
                a[k-1]=idx;
                char temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                k--;
            }
        }
        String str = "";
        for (char c : arr) {
            str += c;
        }
        return str;
    }
}