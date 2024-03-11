import java.util.*;
public class ArrayDeletion {
    public static void main(String args[]){
        int[] array={1,2,34,23,45,10};
       
        //input
        
        int val=10;
        for(int i=0;i<10;i++){
            if(val==array[i]){
                array[i]=array[i+1];
            }
        }
        //output
        for(int i=0;i<10;i++){
            System.out.println(array[i]);
        }
    }
}
//ollection.sort()