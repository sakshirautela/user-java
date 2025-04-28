package com.learn.java.problemsolving;

import java.util.ArrayList;
import java.util.Collections;

public class BestTimeToSellStockIII {
    public static void main(String[] args) {
        System.out.println(bestTimeToSellStock(new int[]{3,2,6,5,0,3}));
    }
    public static int bestTimeToSellStock(int[] prices){
        ArrayList<Integer> al=new ArrayList();
        int buyprice=Integer.MAX_VALUE;
        int maxPrice=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]>buyprice){
                maxPrice=Math.max(maxPrice,(prices[i]-buyprice));
                if(i==prices.length-1){
                    al.add(maxPrice);
                }
            }else{
                buyprice=prices[i];
                al.add(maxPrice);
                maxPrice=0;
            }
        }
        Collections.sort(al,Collections.reverseOrder());
        System.out.println(al);
        int k=2;
        int res=0;
        int i=0;
        while(i<al.size() && k>0){
            res+=al.get(i);
            i++;
            k--;
        }
        return res;
    }
}
