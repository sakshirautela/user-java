import java.util.*;


class FrequencySort {
    static class Info implements Comparable<Info> {
        int n;
        int freq;
        public Info(int n, int freq){
            this.n = n;
            this.freq = freq;
        }
        public int compareTo(Info a) {
            if(this.freq != a.freq){
                return this.freq - a.freq;
            }
            else{
                return a.n - this.n;
            }
        }
    }
    public static int[] frequencySort(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while (start<end) {
            int temp = nums[end];
            nums[end] =nums[start];
            nums[start] =temp;
            start++;end--;
        }
        HashMap<Integer, Integer>hm=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int dp[][]=new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            dp[i][0]=nums[i];
            dp[i][1]=hm.get(nums[i]);
        }
        Arrays.sort(dp,(a,b)->a[1]-b[1]);
        int[] res=new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=dp[i][0];
        }
        return res;
    }
    public static int[] freqSort(int[] nums){
        PriorityQueue<Info> res=new PriorityQueue<Info>();
        HashMap<Integer, Integer>hm=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for (int i : nums) {
            res.add(new Info(i,hm.get(i)));
        }
        int[] result=new int[nums.length];
        int idx=0;
        while(!res.isEmpty()){
            // result[idx++]=res.peek().num;
            result[idx]=(res.peek().n);
            idx++;
            res.remove();
        }
        return result;
    }
    public static void main(String[] args){
        int[] num={ 2, 3, 1, 3, 2};
        int[] nums=freqSort(num);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}