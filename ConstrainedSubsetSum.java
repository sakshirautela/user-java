import java.util.*;
public class ConstrainedSubsetSum {
    static class Info implements Comparable<Info> {
        int sum,idx;
        public Info(int sum,int idx){
            this.sum = sum;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info a) {
            return a.sum-this.sum;
        }
    }
    public static int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Info> q=new PriorityQueue<Info>();//(Collections.reverseOrder());
        int result=nums[0];
        q.add(new Info(nums[0],0));
        for(int i=1; i<nums.length; i++){
            while (!q.isEmpty() && i-q.peek().idx>k) {
                q.remove();
                System.out.println(q.peek().sum+" "+q.peek().idx);

            }
            System.out.println(q.peek().sum+" "+q.peek().idx);
            int curr=Math.max(nums[i],q.peek().sum+nums[i]); 
            result=Math.max(result,curr);
            q.add(new Info(curr,i));
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(constrainedSubsetSum(new int[]{ 10, -2, -10, -5, 20},2));
    }
}