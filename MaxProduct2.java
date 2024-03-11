class MaxProduct2 {
    public static int maxProduct(int[] nums) {
        int product = 1;
        int max_p = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            max_p = Math.max(max_p, product);
            
            if(i+1==nums.length-1 && (nums[i+1]>0 && product<0)){
                product=1  ;

            }
            else if( product==0 ){
                product=1  ;
            }
        }
        return max_p;
    }

    public static void main(String[] args) {
        int[] res = { -3,1, 4 };
        System.out.println(maxProduct(res));
    }
}