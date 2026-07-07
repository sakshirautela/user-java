package problemsolvingIII;

public class ProcessStringwithSpecialOperationsII {
    static void main() {
        System.out.println(processStr("a#b%*",1));
    }

    public static char processStr(String s, long k) {
        StringBuilder sb = new StringBuilder();
        boolean first = false;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                sb.append(sb);
            } else if (c == '*') {
                if(!sb.isEmpty()) {
                    if (first) {
                        sb.deleteCharAt(0);
                    } else {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            } else if (c == '%') {
                first = !first;
            } else {
                if (first) {
                    sb.insert(0,c);
                }else {
                    sb.append(c);
                }
            }
        }
        if(sb.length()>k){
            if(first){
                return sb.charAt((int) (sb.length() - k-1));
            }else{
                return sb.charAt((int) (k));
            }
        }
        return '.';
    }
}
