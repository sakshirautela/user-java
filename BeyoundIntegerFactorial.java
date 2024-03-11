public class BeyoundIntegerFactorial {
    public static void main(String[] args){
        int num[]={1,2,3};
        int idx=num.length-1;
        for (int i = 10;i >=0; i--) {
            decrement(num, idx);
            System.out.println(num[0]+" "+num[1]+" "+num[2]);
        }
    }

    private static void decrement(int[] num,int idx) {
        if(idx<0){
            return ;
        }
        while (num[idx]==0) {
            idx--;
        }
        if(idx>=0){
            num[idx]=num[idx]-1;
        }
    }
}
