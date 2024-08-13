public class KthElementInSortedArray {
    public static long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int i=0;
        int j=0;
        while(i<arr1.length || j<arr2.length){
            if(arr1[i]<=arr2[j]){
                k--;
                if(k==0){
                    return arr1[i];
                }
                i++;
            }else{
                k--;
                if(k==0){
                    return arr2[j];
                }
                j++;
            }
        }
        return j;
    }
    public static void main(String agrs[]){
        System.out.println(kthElement(5,new int[]{2, 3, 6, 7, 9},new int[]{1, 4, 8, 10}));
    }
}