import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {}));
    }

    static int majorityElement(int arr[]) {
        // code here
        int n=arr.length/2;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int key:hm.keySet()){
            if(hm.get(key)>n){
                return key;
            }
        }
        return -1;
    }
}