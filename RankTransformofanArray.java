package com.learn.java.problemsolving;

import java.util.HashMap;
import java.util.Arrays;

public class RankTransformofanArray {
    public static int[] arrayRankTransform(int[] arr) {
        int idx=0;
        int[] arrCpoy=new int[arr.length];
        for(int i:arr){
            arrCpoy[idx++]=i;
        }
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        Arrays.sort(arrCpoy);
        int rank=1;
        hm.put(arrCpoy[0],rank);
        for (int i = 1; i < arr.length; i++) {
            if(arrCpoy[i]!=arrCpoy[i-1]){
                rank++;
            }
            hm.put(arrCpoy[i], rank);
        }
        for (int i = 0; i < arrCpoy.length; i++) {
            arr[i]=hm.get(arr[i]);
        }
        return arr;
    }
        public int[] arrayRankTransform2(int[] arr) {
            int[] res = new int [arr.length];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int val: arr) {
                max = Math.max(val, max);
                min = Math.min(val, min);
            } 
        
            if (max - min > 200 && arr.length < 10) {
                int [] tmp = arr.clone();
                Arrays.sort(arr);
                int index = 1;
                boolean isRepeat = false;
                for (int i = 0; i < arr.length; i++) {
                    int val = arr[i];
                    isRepeat = false;
                    for (int j = 0; j < tmp.length; j++) {
                        if (tmp[j] == val) {
                            if (isRepeat) {
                                i++;
                            }
                            res[j] = index;
                            isRepeat = true;
                        }
                    }
                    index++;
                }
                return res;
    
            } else {
                // [40,10,20,30]  nums[0 - 30] 
                // [100]
                int[] nums = new int [max - min + 1];
                for (int i = 0; i < arr.length; i++) {
                    nums[arr[i] - min] = 1;
                }
    
                int rank = 1;
                for (int i = 0; i < max - min + 1; i++) {
                    if (nums[i] == 1) {
                        nums[i] = rank;
                        rank++;
                    }
                }
    
                //System.out.println(Arrays.toString(nums));
                for (int i = 0; i < arr.length; i++) {
                    res[i] = nums[arr[i]-min];
                }
    
                return res;
            }
        }
    public static void main(String args[]){
        int res[]=arrayRankTransform(new int[]{40,10,20,30});
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}   