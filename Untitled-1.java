import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum=0;
        int n=nums.length;
        List<List<Integer>> arr =new ArrayList();
        for(int i=0;i<n;i++){
            int j=i+1;{
                for(int k=j+1;k<n;k++){
                    if(i != j && i != k && j != k ){
                        sum=nums[i] + nums[j] + nums[k] ;
                        if(sum == 0){
                        List<Integer> a = new ArrayList();
                        a.add(nums[i]); 
                        a.add(nums[j]);
                        a.add(nums[k]) ;
                        Collections.sort(a);
                        arr.add(a);
                        
                        }
                    }
                }
                
            j++;
        }
        List<List<Integer>> newList = arr.stream()
                                      .distinct()
                                      .collect(Collectors.toList());
        
        return newList ;
    }
}