import java.util.ArrayList;

public class GenerateallBinaryStrings {
    public static void main(String[] args) {
        System.out.println(binstr(3));
    }
        public static ArrayList<String> binstr(int n) {
            // code here
ArrayList<String> res=new ArrayList<>();
char[] s=new char[n];
            for (int i = 0; i < n; i++) {
                s[i]='0';
            }
            binstrutill(s,n,0,res);
return res;
    }

    private static void binstrutill(char[] s, int n, int i, ArrayList<String> res) {
        if(i==n){
            res.add(new String(s));
            return;
        }
        s[i]='0';
        binstrutill(s,n,i+1,res);
        s[i]='1';
        binstrutill(s,n,i+1,res);
    }
    static ArrayList<String> binstr2(int n) {
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {

            StringBuilder s = new StringBuilder();

            // build string from bits of i
            for (int j = n - 1; j >= 0; j--)
                s.append(((i >> j) & 1) == 1 ? '1' : '0');

            res.add(s.toString());
        }

        return res;
    }
}
