public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
    }

    public static String smallestNumber(String pattern) {
        char ch[] = pattern.toCharArray();
        int n = ch.length;
        char str[] = new char[n + 1];
        for (int i = 1; i <= n + 1; i++) {
            str[i-1] = (char) (i + '0');
        }
        int i = 0, j = 1;
        while (i < n && j < n + 1) {
            while (i < n && ch[i] == 'I') {
                i++;
                j++;
            }
            if (i >= n || j >= n + 1)
                break;

            int ptr = j - 1;
            while (i < n && ch[i] == 'D') {
                j++;
                i++;
            }
            j--;
            rotate(str, ptr, j);
            j++;
        }
        return String.valueOf(str);
    }

    private static void rotate(char[] str, int ptr, int j) {
        while (ptr<j) {
            char temp=str[ptr];
            str[ptr]=str[j];
            str[j]=temp;
            j--;
            ptr++;
        }
    }
}