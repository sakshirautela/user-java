public class MissingelementofAP {
    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{}));
    }
    public static int findMissing(int[] arr) {
        // code here
        int n=arr.length;
        int d=arr[1]-arr[0];
        for (int index = 2; index <n; index++) {
            if(arr[index]-arr[index-1]>2*d){
                return arr[index-1]+d;
            }
        }
        return arr[n-1]+d;
    }
}