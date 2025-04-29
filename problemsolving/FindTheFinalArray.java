
public class FindTheFinalArray {
    public static long[] finalArray(int n, int[] B) {
        // code her
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            int nums=B[i]-1;
            arr[i]+=B[i];
            int idx=i+1;
            while (idx<n && nums>0) {
                arr[idx]+=nums;
                idx++;
                nums--;
            }
        }
        return arr;

    }
    public static void main(String args[]) {
        long[] arr=(finalArray(5,new int[]{3,1,3,4,5}));
        for(long i:arr){
            System.out.println(i);
        }
    }
    //3 3 5 4 4
    //3 3 4 6 9
}
