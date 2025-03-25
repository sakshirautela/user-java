import java.util.HashMap;

public class ArraysSubset {
    public static void main(String[] args) {
        System.out.println(isSubset(new int[] {}, new int[] {}));
    }

    public static boolean isSubset(int a[], int b[]) {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:b){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:a){
            hm.put(i,hm.getOrDefault(i,0)-1);
            if(hm.get(i)<=0){
                hm.remove(i);
            }
        }
        return (hm.size()==0);
    }
}