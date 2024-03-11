class uniqueElement {
        public static void main(String ...args) {
        int[] nums={};
        int ans=-1;
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=start+end/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1] ){
                ans= mid;
            }
            else if ((nums[mid] == nums[mid + 1]
                      && mid % 2 == 0)
                     || (nums[mid] == nums[mid - 1]
                         && mid % 2 != 0))
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println(ans);
    }
}