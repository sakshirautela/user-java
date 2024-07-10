//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function template for Java
public class DNF {
    public static void sort012(int a[], int n) {
        // code here
        int mid = 0, beg = 0, end = n - 1, temp;
        while (mid < end) {
            if (a[mid] == 0 ) {
                temp = a[mid];
                a[mid] = a[beg];
                a[beg] = temp;
                if(mid==beg){
                    beg++;
                    mid++;
                }else{
                    beg++;
                }
            }
            else if (a[mid] == 1) {
                mid++;
            }
            else {
                temp = a[mid];
                a[mid] = a[end];
                a[end] = temp;
                end--;
            }
        }
    }

    // { Driver Code Starts.
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        // while(t-->0){
        // int n = Integer.parseInt(br.readLine().trim());
        int arr[] = { 0, 2, 1, 2, 0 };
        int n = arr.length;
        // String inputLine[] = br.readLine().trim().split(" ");
        // for(int i=0; i<n; i++){
        // arr[i] = Integer.parseInt(inputLine[i]);
        // }
        // DNF ob=new DNF();
        sort012(arr, n);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n; i++) {
            str.append(arr[i] + " ");
        }
        System.out.println(str);
    }
}

// } Driver Code Ends