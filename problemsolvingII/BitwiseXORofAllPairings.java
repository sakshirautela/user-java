
public class BitwiseXORofAllPairings {
    public static void main(String[] args) {
        System.out.println(xorAllNums(new int[]{2,1,3},new int[]{10,2,5,0}));
    }
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int result=0;
        int result1=0;
        int n=nums1.length;
        int m=nums2.length;
        if(m%2==1){
            for(int i:nums1){
                result^=i;
            }
        }
        if(n%2==1){
            for(int i:nums2){
                result1^=i;
            }
        }
        return result^result1;
    }
}
