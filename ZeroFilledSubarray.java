import java.util.ArrayList;

public class ZeroFilledSubarray {
    public static void main(String[] args) {
        int[] array={1,3,0,0,2,0,0,4};
        System.out.println(subarrayCount(array)); 
    }
    public static int subarrayCount(int[] array){
        int count=0;
        int result=0;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]==0){
                count++;
            }
            else{
                count=0;
            }
            result+=count;
        }
        return result;
    }
}
