public class a1 {
    static void main() {
        System.out.println(reverseByType(")ebc#da@f("));
    }
    public  static String reverseByType(String s) {
        int n=s.length();
        boolean ischar[]=new boolean[n];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)>=97 && s.charAt(i)<=122) {
                ischar[i]=true;
            }
        }
        char c[]=new char[n];
        StringBuilder sb= new StringBuilder();
        StringBuilder st= new StringBuilder();
        for (int i = n-1;i>=0;i--) {
            if(ischar[i]) {
              sb.append(s.charAt(i));
            }else{
                st.append(s.charAt(i));
            }
        }
        int a=0;
        int b=0;
        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i <n ; i++) {
            if(ischar[i]) {
                sb1.append(sb.charAt(a));
                a++;
            }else{
                sb1.append(st.charAt(b));
                b++;
            }
        }
return sb1.toString();
    }
}