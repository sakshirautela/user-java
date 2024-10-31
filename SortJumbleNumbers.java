import java.util.HashMap;

public class SortJumbleNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i:nums){
            hm.put(i,jumbled(i,mapping));
        }
    }
    public static int jumbled(int n,int[] mapping){
        String res="";
        while(n>0){
            int rem=n%10;
            res=('a'+mapping[rem])+res;
        }
        return Integer.parseInt(res);
    }
    public static void main(String args[]){
        int[] res=sortJumbled(new int[]{},new int[]{});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}