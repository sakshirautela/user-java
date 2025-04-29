//Initial Template for Java


// } Driver Code Ends


//User function Template for Java

public class CountFriendsPairings
{
    public static void main(String[] args) {
        
    }
    public int countFriendsPairings(int n)
    {
       //code here
       int i;
       int a[]=new int[n+1];
       for( i=0;i<n;i++)
       {
           if(i<=2)
           {
               a[i]=i;
           }
           else
           {
               a[i]=a[n-1]+(n-1)*a[n-2];
           }
       }
       return a[i];

    }
}
