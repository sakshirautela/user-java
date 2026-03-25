public class NumberStepstoReduceaNumberinBinaryRepresentationtoOne {
    static void main() {
        System.out.println(numSteps("1101"));
    }

    public static int numSteps(String s) {
        int n = s.length();
        int[] num =new int[n+1];
        int one=0;
        for(int i=1;i<=n;i++){
            num[i] = s.charAt(i-1)-'0';
            one+=num[i];
        }
        if(one==1) {
            return 0;
        }
        int steps=0;
        while(true){
            steps++;
            int o=0;
            if(num[n]==0){
               o=numSteps1(num);
            }else{
                o=numSteps2(num);
            }
            if(o==1){
                return steps;
            }
        }
    }

    private static int numSteps1(int[] num) {
        int n=num.length-1;
        int one=0;
        while(n>0){
            num[n]=num[n-1];
            one+=num[n-1];
            n--;
        }
        num[0] =0;
        return one;
    }

    public static int numSteps2( int[] num) {
        int n = num.length-1;
        int rem=1;
        int one=0;
        while (n>=0 && num[n]!=0) {
            rem=(rem+num[n])/2;
            num[n]=(num[n]+rem)%2;
            one+=num[n];
            n--;
        }
        if(rem==1 && n>=0) {
            num[n]=rem;
            one+=num[n];
            n--;
        }
        while(n>=0) {
            one+=num[n];
            n--;
        }
        return one;
    }
}
