//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            MinimumJumpstoReachEndviaPrimeTeleportation ob = new MinimumJumpstoReachEndviaPrimeTeleportation();
            System.out.println(countFriendsPairings(n));
        }
        sc.close();
    }
// } Driver Code Ends

// User function Template for Java

    public static int countFriendsPairings(int n) {
        // code here
        int i;
        int a[] = new int[n + 1];
        for (i = 0; i < n; i++) {
            if (i <= 2) {
                a[i] = i;
            } else {
                a[i] = a[n - 1] + (n - 1) * a[n - 2];
            }
            i++;
        }
        return a[i];

    }
}
