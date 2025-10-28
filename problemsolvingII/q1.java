import java.util.PriorityQueue;

public class q1 {
    public static void main(String[] args) {
        System.out.println(lexSmallest("dcab"));
    }
        public static String lexSmallest(String s) {
int n=s.length();
String str="";
            PriorityQueue<String> pq=new PriorityQueue<>();
            for (int i = 0; i < n; i++) {

                StringBuilder sb= new StringBuilder(s.substring(0, i));
                pq.add(sb.reverse().toString()+s.substring(i));
            }
                for (int i = 0; i < n; i++) {
                StringBuilder sb= new StringBuilder((s.substring(i, n)));
                pq.add(s.substring(0,i)+sb.reverse().toString());
            }
                if(pq.isEmpty()){
                    return "";
                }
                return pq.peek();
        }
}
