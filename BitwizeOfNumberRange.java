public class BitwizeOfNumberRange {
    public static int rangeBitwiseAnd(int left, int right) {
        // int res=left;
        // for(int i=left+1;i<=right;i++){
        //     res=(res & i);
        //     if(res==0){
        //         return 0;
        //     }
        // }
        // return res;
        while(right>left){
            right&=(right-1);
        }
        return right;
    }
    public static void main(String[] args){
        System.out.println(rangeBitwiseAnd(1073741824,2147483647));
    }
}