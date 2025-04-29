
import java.util.HashMap;

public class KthDistinctStringInArray {
    public static String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> hm=new HashMap();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(hm.get(arr[i])==1){
                if(k==1){
                    return arr[i];
                }
                k--;
            }
        }
        return "";
    }
    public static void main(String args[]){
        System.out.println(kthDistinct(new String[]{},2));
    }
}
