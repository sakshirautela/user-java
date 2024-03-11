import java.util.ArrayList;

public class ThreeSubarrays {
    public static int solve(ArrayList<Integer> A) {
        int n=A.size();
        if(n==0){
            return 0;
        }
        ArrayList<Integer> prefix=new  ArrayList<>();
        ArrayList<Integer> mid=new  ArrayList<>();
        ArrayList<Integer> sufix=new  ArrayList<>();
        int lsum=0;
        int k=n/3;
        int maxSum=0;
        for(int i=0;i<k;i++){
            
            lsum+=A.get(i);
            maxSum=Math.max(maxSum,lsum);
            if(lsum<0){
                lsum=0;
            }
            if(i==k-1){
                prefix.add(maxSum);
            }
        }
        int maxSum1=0;
        int j=2*k;
        int Sum=0;
        for(int i=k;i<j;i++){
            Sum+=A.get(i);
            
            maxSum1=Math.max(maxSum1,Sum);
            if(Sum<0){
                Sum=0;
            }
            if(i==k-1){
                mid.add(maxSum1);
            }
        }
        int maxSum2=0;
        int rSum=0;
        for(int i=j;i<n;i++){
            rSum+=A.get(i);
            maxSum2=Math.max(maxSum2,rSum);
            if(rSum<0){
                rSum=0;
            }
            if(i==k-1){
                sufix.add(maxSum2);
            }
        }
        int sum=prefix.get(0)+mid.get(0)+sufix.get(0);
        return sum;
    }
    public static void main(String[] args) {

        ArrayList<Integer> array=new ArrayList();
        array.add(2);
        array.add(-3);
        array.add(-1);
        array.add(4);
        System.out.println(solve(array));
    }
}
