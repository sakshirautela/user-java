
public class SumOfElementOfMiddleElementOfTwoSortedArray {
    public static int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int i=0,j=0;
        int idx=0;
        int[] merged=new int[arr1.length+1];
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                merged[idx]=arr1[i];
                i++;
            }else{
                merged[idx]=arr2[j];
                j++;
            }
            idx++;
            if(idx==merged.length){
                break;
            }
        }
        
        return merged[merged.length-1]+merged[merged.length-2];
    }
    public static void main(String args[]){
        System.out.println(SumofMiddleElements(new int[]{1, 2, 4, 6, 10},new int[]{4, 5, 6, 9, 12}));
    }
}
