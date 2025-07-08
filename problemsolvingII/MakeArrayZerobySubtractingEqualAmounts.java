public class MakeArrayZerobySubtractingEqualAmounts {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{}));
    }
    public static int minimumOperations(int[] nums) {
        int result=0;
        boolean[] ispresent=new boolean[101];
        for(int num:nums){
            if(!ispresent[num]&& num!=0){
                result++;
                ispresent[num]=true;
            }
        }
        return result;
    }
}