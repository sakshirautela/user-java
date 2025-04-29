
public class TotalCost {
    static int totalCount(int k, int[] arr) {
        // code here
        int result=0;
        for(int i:arr){
            result+=getNum(i,k);
        }
        return result;
    }
    private static int getNum(int n, int k) {
        int a=0;
        while(n>=k){
            n-=k;
            a++;
        }
        return (n==0)?a:a+1;
    }
    public static void main(String args[]){
        System.out.println(totalCount(3,new int[]{5, 8, 10, 13}));
    }
}
