package problemsolvingIII;

public class CountNumbersContainingSpecificDigits {
    public static void main(String[] args) {
        System.out.println(countValid(1,new int[]{1,2,3}));
        System.out.println(pow(5,3));
    }
public static int pow(int num, int power){
        int result=1;
        while (power>0){
            if((power&1)!=0){
                result*=num;
            }
            num*=num;
            power>>=1;
        }
        return result;
}
    public static int countValid(int n, int[] arr) {
        // code here
        int total=9*pow(10,n-1);
        boolean isPresent[]=new boolean[10];
        for(int i:arr){
            isPresent[i]=true;
        }
        int digit=0;
        int nonzero=0;
        for (int i = 0; i <=9 ; i++) {
            if(!isPresent[i]){
                digit++;
                if(i!=0){
                    nonzero++;
                }
            }
        }
        int notvalid=(n==1)?nonzero:nonzero*pow(digit,n-1);
        return total-notvalid;
    }
}
