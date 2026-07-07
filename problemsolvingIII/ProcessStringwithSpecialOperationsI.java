package problemsolvingIII;

public class ProcessStringwithSpecialOperationsI {
    static void main() {
        System.out.println();
    }

    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(char c : s.toCharArray()) {
            if(c=='#'){
                sb.append(sb);
            }else if(c=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else if(c=='%'){
                sb.reverse();
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
