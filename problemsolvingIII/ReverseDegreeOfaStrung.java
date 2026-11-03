package problemsolvingIII;

public class ReverseDegreeOfaStrung {
    static void main() {
        System.out.println(reverseDegree("zaza"));
    }
        public static  int reverseDegree(String s) {
            int sum=0;
            int n=s.length();
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                sum+=(26-(ch-'a'))*(i+1);
            }
            return sum;
        }
}
