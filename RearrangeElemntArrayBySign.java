public class RearrangeElemntArrayBySign {
    public static int[] rearrangeArray(int[] nums) {
        int[] result=new int[nums.length];
        int pos=0;
        int neg=1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                result[pos]=nums[i];
                pos+=2;
            }else{
                result[neg]=nums[i];
                neg+=2;
            }
        }
        return result;
    }
    public static void main(String[] args){

        int[] result=rearrangeArray(new int[]{39,-8,-28,46,-16,-21,-12,49,14,-46,22,9});
        for(int i=0; i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}