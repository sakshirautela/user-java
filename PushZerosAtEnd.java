import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PushZerosAtEnd {
    public static void pushZerosAtEnd(ArrayList<Integer> arr) {
        // Write your code here.
        int ptr1 = 0;
        int ptr2 = 1;
        while (ptr1 < arr.size() && ptr2 < arr.size()) {
            if (arr.get(ptr1) == 0 && arr.get(ptr2) != 0) {
                Collections.swap(arr, ptr1, ptr2);
            } else if (arr.get(ptr1) == 0 && arr.get(ptr2) == 0) {
                ptr2++;
            } else if (arr.get(ptr1) != 0 && arr.get(ptr2) == 0) {
                ptr1++;
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 0};
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        pushZerosAtEnd2(list);
    }public static void pushZerosAtEnd2(ArrayList<Integer> arr)
	{
		// Write your code here.
        int ptr = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=0){
                Collections.swap(arr, i, ptr);
                ptr++;
            }
        }
        System.out.println(arr);
	}

}