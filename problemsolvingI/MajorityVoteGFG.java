
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class MajorityVoteGFG {
    // Function to find the majority elements in the array
    public static List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n=nums.size();
        List<Integer> list=new ArrayList<Integer>();
        HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for(int key:freq.keySet()){
            if(freq.get(key)>n/3){
                list.add(key);
            }
        }
        if(list.size()==0){
            list.add(-1);
        }
        return list;
    }
    public static void main(String args[]){
        System.out.println(findMajority(new ArrayList<Integer>(Arrays.asList(1,2,3,4))));
    }
}
