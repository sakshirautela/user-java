public class BinarySearchVpn {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(BSearch(arr,5));
    }
    public static boolean BSearch(int arr[],int val){
        boolean found = false;
        int end=arr.length-1;
        int start=0;
        while(start<=end){
            int mid=(end+start)/2;
            if(arr[mid]==val){
                found=true;
                break;
            }
            else if(arr[mid]>val){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return found;
    }
}
