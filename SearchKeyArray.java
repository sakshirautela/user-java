import java.util.ArrayList;

public class SearchKeyArray {
    public static void main(String[] args) {
        int arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        keysearch(arr, key, 0, new ArrayList<>());
    }
    public static void keysearch(int[] array,int key,int i,ArrayList<Integer> count){ 
        //base case
        if(i==array.length){
            System.out.println(count);
            return;
        }
        if(array[i]==key){
            count.add(i);
        }
        keysearch(array, key, i+1,count);
    }
}
