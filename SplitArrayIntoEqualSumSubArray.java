public class SplitArrayIntoEqualSumSubArray {
    public static boolean canSplit(int arr[]) {
        // code here
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        int s=0;
        int target=sum/2;
        for(int i=0;i<arr.length-1;i++){
            s+=arr[i];
            if(s==target){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(canSplit(new int[]{4,1,2,3,4}));
    }
}