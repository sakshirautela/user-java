import java.util.HashSet;
public class CountDistinctElement {
    public static void main(String[] args) {
        int nums[]={1,3,5,6,8,9,3,2,8};
        HashSet<Integer> hs=new HashSet();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        System.out.println(hs.size());
    }
}
