import java.util.ArrayList;

public class nextGreater {
    // public static void swap(int a, int b) {

    // }

    // public static void reverse(ArrayList<Integer> new_array2) {
    //     ArrayList<Integer> new_array = new ArrayList();

    // }

    public static void main(String args[]) {
        int[] array = { 2, 1, 8, 7, 6, 5 };
        int temp = array[array.length - 1];
        int idx = 0;
        int k = 0;
        ArrayList<Integer> sample=new ArrayList();
        int[] new_array = new int[array.length];
        int temp2 = - 1;
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = array.length - 2; j >= 0; j--) {
                if (array[i] > array[j] && temp > array[j]) {
                    idx = i;
                    temp = array[j];
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }

            }

        }
       for (int j = array.length -1; j >= 0; j--) {

                if (temp2 < array[j] && temp2 < array[j]) {
                    temp2=array[j];
                    idx=j;
                    sample.add(array[j]);
                }
                
            

        }
        //System.out.println(sample);
        
        int j=0;
        
        for(int i=idx;i<array.length;i++){
            array[i]=sample.get(j);
            j=j+1;
            //System.out.println(array[i]);

        }
        //array[idx]=sample.get(j);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
