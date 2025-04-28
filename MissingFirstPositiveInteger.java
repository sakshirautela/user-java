package com.learn.java.problemsolving;

import java.util.*;

public class MissingFirstPositiveInteger {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{-1,1,3,4,5});
    }
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        ArrayList list=new ArrayList();
        Iterator it=st.iterator();
        while(it.hasNext()){
            list.add((int)it.next());
        }
        System.out.println(list);
        return 0;
    }
}
