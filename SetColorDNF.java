public class SetColorDNF {
    public void sortColors(int[] nums) {
        int mid=0;
        int low=0;
        int high=nums.length-1;
        while(high>=mid){
            if(nums[mid]==0){
                //swap(nums[mid],nums[low]);
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                //swap(nums[mid],nums[high]);
                    int temp=nums[mid];
                    nums[mid]=nums[high];
                    nums[high]=temp;
                    high--;
                    //mid++;
            }
        }
    }
    public void sortColors2(int[] nums){
        int count0=0;
        int count1=0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                count0++;
            }
            else if (nums[i] == 1) {
                count1++;
            }
            else {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count0>0) {
                nums[i]=0;
                count0--;
            } else if (count1> 0) {
                nums[i]=1;
                count1--;
            } else {
                nums[i]=2;
                count2--;
            }
        }

    }
    public static void main(String[] args) {
        SetColorDNF col = new SetColorDNF();
        int[] color = { 1,2,0};
        col.sortColors(color);
        for (int i = 0; i < color.length; i++) {
            System.out.println(color[i]);

        }
    }
}
