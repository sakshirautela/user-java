public class MaximumNumberofSubsequencesAfterOneInserting {
    public static void main(String[] args) {
        System.out.println(numOfSubsequences("LCC"));
    }

    public static long numOfSubsequences(String s) {
        int cons = 1;
        int result = 1;
        boolean l = false;
        boolean t = false;
        boolean c = false;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                l = true;
                sb.append(ch);
            } else if (ch == 'C') {
                c = true;
                sb.append(ch);
            } else if (ch == 'T') {
                sb.append(ch);
                t = true;
            }
        }
        if (!(l && t) || !(t && c) || !(l && c)) {
            return 0;
        }
        boolean isinsert=false;
        if(c && t && l){
            isinsert=true;
        }
        int n = sb.length();
        for (int i = 1; i < n; i++) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                cons++;
            } else {
                result *= cons;
                cons = 1;
            }
        }
        result *= cons;
        result *= 2;
        return result;
    }
}
