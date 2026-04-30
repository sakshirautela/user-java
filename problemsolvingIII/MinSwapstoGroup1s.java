package problemsolvingIII;

public class MinSwapstoGroup1s {
    static void main() {
        System.out.println(minSwaps(new int[]{1 ,1 ,0, 0, 1, 0, 0, 1, 0, 0, 0, 1}));
    }

    public static int minSwaps(int[] arr) {
        // code here
        int n = arr.length;
        int op=0;
        int one=0;
        for(int i=0;i<n;i++){
            one+=arr[i];
        }
        int k=0;
        int sum=0;
        int result=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while (i-k>one){
                sum-=arr[k];
                k++;
            }
            result=Math.max(result,sum);
        }
        return one-result;
    }
}
