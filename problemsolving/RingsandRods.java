import java.util.ArrayList;

public class RingsandRods {
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
    public static int countPoints(String rings) {
        ArrayList<boolean[]> al=new ArrayList<boolean[]>(10);
        for (int index = 0; index < 10; index++) {
            al.add(new boolean[4]);
        }
        int n=rings.length();
        int res=0;
        for (int i = 0; i < n; i=i+2) {
            char color=rings.charAt(i);
            int idx=rings.charAt(i+1)-'0';
            if(color=='R'){
                al.get(idx)[0]=true;
            }else if(color=='G'){
                al.get(idx)[0]=true;
            }else{
                al.get(idx)[0]=true;
            }
            if(al.get(idx)[0]&&al.get(idx)[2]&& al.get(idx)[1] && !al.get(idx)[3]){
                res++;
                al.get(idx)[3]=true;
            }
        }
        return res;
    }
}
