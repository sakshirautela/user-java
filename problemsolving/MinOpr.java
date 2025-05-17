import java.util.*;

public class MinOpr {
    public static void main(String[] args) {
        System.out.print(minimumOperations(new int[] { 3, 1, 2, 1 }));
    }

    public static int minimumOperations(int[] nums) {
        int operations = 0;
        TreeMap<Integer,Integer> freq=new TreeMap<>();
        for (int num : nums) {
            if (num != 0) {
                freq.put(num,freq.getOrDefault(num,0)+1);
            }
        }
        ArrayList<int[]> al=new ArrayList<>();
        for(int k:freq.keySet()){
            al.add(new int[]{k,freq.get(k)});
        }
        Collections.sort(al,(a,b)->b[1]-a[1]);
        // for(int i[]:al){
            
        // }
        return operations;
    }
}