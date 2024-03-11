import java.util.*;

public class SingleElement {
    static int singleElement(int[] arr , int N) {
        // code here
        HashMap<Integer, Integer> map = new HashMap();
        int res=-1;
        for(int i=0;i<N;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)==1){
                res=i;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(singleElement(new int[]{3, 2, 1, 34, 34, 1, 2, 34, 2, 1}, 10));
    }
}