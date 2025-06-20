import java.util.HashMap;

public class CheckEqualArrays {
    public static void main(String[] args) {
        System.out.println(checkEqual(null, null));
    }
    public static boolean checkEqual(int[] a, int[] b) {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i : a) {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for (int i : b) {
            hm.put(i,hm.getOrDefault(i,0)-1);
        }
        for (int i : hm.keySet()) {
            if(hm.get(i)!=0){
                return false;
            }
        }
        return true;
    }
}