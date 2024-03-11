public class PairSum {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(findSum(nums, 3));
    }
    public static boolean findSum(int[] array,int target){
        int lp=0;
        int rp=array.length-1;
        for(int i=0;i<array.length;i++){
            int sum = array[rp]+array[lp];

            if(target==sum){
                return true;
            }
            else if(target<sum){
                rp--;
            }
            else{
                lp++;
            }
        }
        return false;
    }
}
