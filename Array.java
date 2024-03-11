public class Array {
    public static void main(String[] args) {
        int[] arr=new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        int k=3;

        for (int i =arr.length-1;i>k; i--) {
            arr[i]=arr[i-1];
        }
        arr[k] = 2;

        // //for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }

        // remove element
        for (int i = k; i <arr.length-1; i++) {
            arr[i] = arr[i +1];
        }
        arr[arr.length-1]=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] a=new int[4];
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
