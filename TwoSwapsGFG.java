package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSwapsGFG {
    public static boolean checkSorted(List<Integer> arr) {
        // code here
        int minSwap=0;
        for(int i=0; i<arr.size(); i++){
            while(i+1 != arr.get(i)){
                int ind=arr.get(i)-1;
                int t=arr.get(ind);
                arr.set(ind, arr.get(i));
                arr.set(i, t);
                minSwap++;
            }
        }
        
        if(minSwap==0 || minSwap==2)  return true;
        return false;
    }
    public static void main(String args[]) {
        System.out.println(checkSorted(new ArrayList<Integer>(Arrays.asList(4,3,2,1))));
    }
}
