public class LargestPairSumGFG {
    public static int pairsum(int[] arr) {
        // code here
        int firstMax=0;
        int secondMax=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>firstMax){
                secondMax=firstMax;
                firstMax=arr[i];
            }else if(arr[i]>secondMax){
                secondMax=arr[i];
            }
        }
        return firstMax+secondMax;
    }
    public static void main(String args[]) {
        System.out.println(pairsum(new int[]{12 ,34, 10, 6 ,40}));
    }
}
