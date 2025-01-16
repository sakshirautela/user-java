public class SecondLargestElement {
    public static int getSecondLargest(int[] arr) {
        // Code Here
        int n=arr.length;
        int second=-1;
        int first=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if(arr[i]<first && arr[i]>second){
                second=arr[i];
            }
        }
        return second;
    }
    public static void main(String[] args){
        System.out.println(getSecondLargest(new int[]{}));
    }
}
