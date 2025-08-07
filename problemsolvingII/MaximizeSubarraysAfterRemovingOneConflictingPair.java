public class MaximizeSubarraysAfterRemovingOneConflictingPair {
    public static void main(String[] args) {
        System.out.println(maxSubarrays(5, new int[][]{}));
    }

    public static long maxSubarrays(int n, int[][] conflictingPairs) {
int result=0;
    int pow=0;
for(int i=1;i<=n;i++){
    pow+=2;
    result+=(n-i-1)*(i);
    System.out.println((n-i-1)*(i));
}
System.out.println(pow);
return result;
    }
}
