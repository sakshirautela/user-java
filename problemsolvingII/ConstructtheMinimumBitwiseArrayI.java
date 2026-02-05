import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructtheMinimumBitwiseArrayI {
    static void main() {
        int[] res = minBitwiseArray(new ArrayList<>());
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean isfound = false;
            for (int j = 1; j < nums.get(i); j++) {
                if ((j | (j + 1)) == nums.get(i)) {
                    res[i] = j;
                    isfound = true;
                    break;
                }
            }
            if (!isfound) {
                res[i] = -1;
            }
        }
        return res;
    }
        public int[] minBitwiseArrayFast(List<Integer> nums) {
            int [] ans= new int[nums.size()];
            Arrays.fill(ans,-1);
            for(int i=0;i<ans.length;i++){
                int temp=nums.get(i);
                int min=Integer.MAX_VALUE;
                if( ((temp+1)& temp)!=0){
                    for(int j=0;j<32;j++){
                        if((temp & (1<<j))!=0){
                            int temp1=(temp & ~(1<<j));
                            if((temp1 | (temp1+1)) == temp){
                                min=Math.min(min,temp1);
                            }
                        }
                    }
                    if(min != Integer.MAX_VALUE )
                        ans[i]=min;
                }
                else{
                    int n= temp;
                    int position=-1;
                    while(n>0){
                        position++;
                        n=n>>1;
                    }
                    ans[i]= (temp & ~(1<< (position)));
                }
            }
            return ans;
        }
}
