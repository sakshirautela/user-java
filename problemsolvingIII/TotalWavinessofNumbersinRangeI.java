package problemsolvingIII;

public class TotalWavinessofNumbersinRangeI {
    static void main() {
        System.out.println(totalWaviness(3,4));
    }
        public  static int helper(int num) {
            int ans=0;

            int last=num%10;
            num/=10;
            int curr=num%10;
            num/=10;

            while(num>0) {
                int next=num%10;
                num/=10;
                if((curr>last && curr>next) || (curr<last && curr<next)) {
                    ans++;
                }
                last=curr;
                curr=next;
            }
            return ans;
        }
        public static int totalWaviness(int num1, int num2) {

            int ans=0;
            for(int i=num1;i<=num2;i++) {
                if(i<100) continue;
                ans+=helper(i);
            }
            return ans;
        }
}
