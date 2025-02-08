public class LongestPalindromeArrays {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new int[]{3,2}));
    }
    static boolean isPlaindrom(int[] arr){
        int i=0;
        int j=arr.length;
        while (i<j) {
            if(arr[i]!=arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int longestPalindrome(int[] arr) {
        // code here
        long sum=0;
        for (int i : arr) {
            sum+=i;
        }
    }
}