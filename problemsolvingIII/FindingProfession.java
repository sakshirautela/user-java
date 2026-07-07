package problemsolvingIII;

public class FindingProfession {
    static void main() {
        System.out.println(profession(6,21));
    }

    public static String profession(int level, int pos) {
        int setBit=0;
        pos--;
        while (pos>0){
            setBit+=pos&1;
            pos>>=1;
        }
        if(setBit%2==0){
            return "Engineer";
        }else{
            return "Doctor";
        }
    }
        public static String professionWrong(int level, int pos) {
        // code here
        int n = (int) Math.pow(2, level - 1);
        int change = n / 2;
        boolean first = true;
        if (pos > change) {
            first = false;
            pos -= change;
        }
        int cat = 0;
        boolean up = true;
        int d = pos / 2;
        int r = pos % 2;
        if (first) {
            if (d % 2 == 0) {
                if (r == 1) {
                    return "Doctor";
                } else {
                    return "Engineer";
                }
            } else {
                if (r == 0) {
                    return "Doctor";
                } else {
                    return "Engineer";
                }
            }
        } else {
            if (d % 2 == 1) {
                if (r == 0) {
                    return "Doctor";
                } else {
                    return "Engineer";
                }
            } else {
                if (r == 1) {
                    return "Doctor";
                } else {
                    return "Engineer";
                }
            }
        }
    }
}
