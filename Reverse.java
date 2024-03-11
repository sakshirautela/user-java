public class Reverse {
    public static void reverse(int[] array){
        int n=array.length-1;
        for(int i=0;i<array.length/2;i++){
            int temp=array[i];
            array[i]=array[n];
            array[n]=temp;
            n--;
        }
        //return array;
    }
    public static void main(String...args){
        int[] arr={34,56,33,22,44};
        reverse(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        String result="";
        Integer.toString(0);
    }
}
