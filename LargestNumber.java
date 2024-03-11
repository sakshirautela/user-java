class LargestNumber {
    public String largestNumber(int[] nums) {
        String res="";
        for(int i=0;i<nums.length-1;i++){
            System.out.println(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                String str1=Integer.toString(nums[i])+Integer.toString(nums[j]);
                String str2=Integer.toString(nums[j])+Integer.toString(nums[i]);
                if(Integer.parseInt(str1)<Integer.parseInt(str2)){
                    int temp=nums[i];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
            //System.out.println(nums[i-1]);
            
            
        }
        for (int j = 0; j < nums.length; j++) {
                res+=Integer.toString(nums[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestNumber ln=new LargestNumber();
        int[] arr={ 3, 30 ,34,5 ,9};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println(ln.largestNumber(arr));
    }
}