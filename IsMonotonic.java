class IsMonotonic {
    public static boolean isMonotonic(int[] nums) {
        if(nums.length==1){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isMonotonic(new int[]{1}));
    }
}