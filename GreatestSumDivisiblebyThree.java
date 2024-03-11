import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.text.AbstractDocument.BranchElement;

import java.util.Comparator;

public class GreatestSumDivisiblebyThree {
    public static void main(String[] args) {
    //     System.out.println(greatestSumDivisiblebyThree(new int[]{3,6,5,1,8}));
    // }
    // public static int greatestSumDivisiblebyThree(int[] arr){
        //Arrays.sort(arr,Comparator.reverseOrder());
        int[] nums={ 2, 3, 36, 8, 32, 38, 3, 30, 13, 40};
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i]+" ");
        // }
        // System.out.println();
        // int n = nums.length-1;

        // //int si=0,ei=n-1;
        // // while (si<=ei) {
        // //     int temp=arr[si];
        // //     arr[si]=arr[ei];
        // //     arr[ei]=temp;
        // // }
        // int sum=0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum+=nums[i];
        // }
        // if(sum%3==0){
        //     System.out.println(sum);
        // }
        // System.out.println(sum);
        // int s = 0;
        // int res=0;
        // for (int i = 0; i < nums.length; i++) {
        //     s=sum-nums[i];
        //     if(i+1<nums.length && nums[i]==nums[i+1]){
        //         s=sum - nums[i]-nums[i+1];

        //     }
        //     if(s%3==0 && res<s){
        //         res=s;
        //         break;
        //     }
        // }
        // // while(n>0){
        // //     for(int i=0;i<n;i++){
        // //         sum+=arr[i];
        // //     }
        // //     if(sum%3==0){
        // //         break;
        // //     }
        // //     n--;
        // // }
        // System.out.println(res);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int res = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();

            if((sum-min)%3==0){
                res= sum - min;
                break;
            }
            else if((sum - min2) % 3 == 0){
                res=sum-min2;
                break;
            }
            else{
                pq.add(min + min2);
            }
            
        }
        System.out.println(res);
    }
}
