//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

import GraphDirected.dijkstraPair;

  public class minimizeTheHight {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        ArrayList<dijkstraPair> v = new ArrayList<dijkstraPair>();

        int[] taken = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) {
                v.add(new dijkstraPair(arr[i] - k, i));
            }
            v.add(new dijkstraPair(arr[i] + k, i));
        }

        Collections.sort(v, new Comparator<dijkstraPair>() {
            @Override   public int compare(dijkstraPair p1, dijkstraPair p2) {
                if (p1.first == p2.first) return p1.second - p2.second;
                return p1.first - p2.first;
            }
        });

        int elements_in_range = 0;
        int left = 0;
        int right = 0;
        while (elements_in_range < n && right < v.size()) {
            if (taken[v.get(right).second] == 0) {
                elements_in_range++;
            }
            taken[v.get(right).second]++;
            right++;
        }
        int ans = v.get(right - 1).first - v.get(left).first;
        while (right < v.size()) {
            if (taken[v.get(left).second] == 1) {
                elements_in_range--;
            }
            taken[v.get(left).second]--;
            left++;

            while (elements_in_range < n && right < v.size()) {
                if (taken[v.get(right).second] == 0) {
                    elements_in_range++;
                }
                taken[v.get(right).second]++;
                right++;
            }

            if (elements_in_range == n) {
                ans = Math.min(ans, v.get(right - 1).first - v.get(left).first);
            } else
                break;
        }
        return ans;
    }
    
}
