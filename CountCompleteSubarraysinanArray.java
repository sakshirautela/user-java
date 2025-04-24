import java.util.HashSet;

public class CountCompleteSubarraysinanArray {
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1,3,1,2,2}));
    }
    public static int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return 1;
        }
        HashSet<Integer> unique=new HashSet<>();
        for (int i:nums) {
            unique.add(i);
        }
        int result=0;
        int u=unique.size();
        for(int i=0;i<n;i++){
            HashSet<Integer> temp=new HashSet<>();
            for(int j=(i);j<n;j++){
                if(u!=temp.size()){
                    temp.add(nums[j]);
                }else{
                    result+=n-j;
                    break;
                }
            }
            if(u==temp.size()){
                result++;
            }
        }
        return result;
    }
//     private static boolean isContainsUnique(int i, int j, int[] nums,HashSet<Integer> hs) {
//         HashSet<Integer> temp=new HashSet<>();
//         for(int idx=i;idx<=j;idx++){
//             temp.add(nums[idx]);
//         }
//         return hs.size()==temp.size();
//     }
    public int countCompleteSubarrays2(int[] nums) {
        boolean[] exists = new boolean[2001];
        int distinct = 0;
        for( int n : nums ){
            if( !exists[n] ){
                exists[n] = true;
                distinct++;
            }
        }
        int[] freq = new int[2001];
        int count = 0, n = nums.length;
        int sub = 0;
        for( int start = 0, end = 0; end < n; end++ ){
            if( freq[ nums[ end ] ]++ == 0 )
                count++;
            while( count == distinct ){
                sub += n - end;
                if( freq[ nums[ start ++ ] ]-- == 1 )
                    count--;
            }
        }
        return sub;
    }
}