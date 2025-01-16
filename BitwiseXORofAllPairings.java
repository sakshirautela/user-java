public class BitwiseXORofAllPairings {
    public static void main(String[] args) {
        System.out.println(xorAllNums(new int[]{},new int[]{}));
    }
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int result=0;
        int n=nums1.length;
        int m=nums2.length;
        for(int i:nums1){
            for(int j=0;j<m;j++){
                result^=(i^nums2[j]);
            }
        }
        return result;
    }
}
