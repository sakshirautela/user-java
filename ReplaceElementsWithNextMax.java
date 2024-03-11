public class ReplaceElementsWithNextMax{
    public static int[] replaceElements(int[] arr) {
        int max=-1;
        int temp=max;
        for(int i=arr.length-1;i>=0;i--){
            temp=max;
            if(temp<arr[i]){
                temp=arr[i];
            }
            arr[i]=max;
            max=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] res=replaceElements(new int[]{17,18,5,4,6,1});
        for (int i : res) {
            System.out.print(i+" ");
        }
        // System.out.println(replaceElements(new int[]{17,18,5,4,6,1}).toString());
    }
}