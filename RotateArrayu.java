public class RotateArrayu {
    public static void main(String[] args) {
        int[] nums={-1,-100,3,99};
        int k=2;
        int j=0;
        int n=nums.length-1;
        while(j<n){
            int temp=nums[j];
            nums[j]=nums[n];
            nums[n]=temp;
            j++;
            n--;
        }
        n=k-1;
        j=0;
        if(nums.length<=1){
            System.out.println(nums[0]);
        }
        while(j<n){
            int temp=nums[j];
            nums[j]=nums[n];
            nums[n]=temp;
            j++;
            n--;
        }
        j=k;
        n=nums.length-1;
        while(j<n){
            int temp=nums[j];
            nums[j]=nums[n];
            nums[n]=temp;
            j++;
            n--;
        }
    }
}
