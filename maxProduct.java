package com.learn.java.problemsolving;//{ Driver Code Starts

// } Driver Code Ends


public class MaxProduct {
    public static void main(String[] args) {

    }
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        int mul,result=arr[0];
        for(int i=0;i<n;i++){
            mul=arr[i];
            for(int j=i+1;j<n;j++){
                result=Math.max(result,mul);
                mul*=arr[j];
            }
            result=Math.max(result,mul);
        }    
        return result;
    }
}