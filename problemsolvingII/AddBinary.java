public class AddBinary {
    static void main() {
        System.out.println(addBinary("101111", "10"));
    }

    public static String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int rem = 0;
        StringBuffer res = new StringBuffer();
        while (n >= 0 && m >= 0) {
            int i = a.charAt(n) - '0';
            int j = b.charAt(m) - '0';
            n--;
            m--;
            int add = (i + j + rem) % 2;
            rem = (i + j + rem) / 2;
            res.insert(0, (add));
        }
        while (n >= 0) {
            int i = a.charAt(n) - '0';
            n--;
            int add = (i + rem) % 2;
            rem = (i + rem) / 2;
            res.insert(0, (add));
        }
        while (m >= 0) {
            int i = b.charAt(m) - '0';
            m--;
            int add = (i + rem) % 2;
            rem = (i + rem) / 2;
            res.insert(0, (add));
        }
        if(rem>0){
            res.insert(0,rem);
        }
        return res.toString();
    }

    private static String rev(String a) {
        StringBuilder n = new StringBuilder();
        for (char c : a.toCharArray()) {
            n.insert(0, c);
        }
        return n.toString();
    }
}
