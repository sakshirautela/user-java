import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasketsII {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{},new int[]{}));
    }
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int c=0;
        int in=0;
        while(in<fruits.length){
            for(int j=0;j<fruits.length;j++){
                if(baskets[j]>=fruits[in]){
                baskets[j]=-1;
                c++;
                break;
            }
            }
            in++;
        }
        
        return fruits.length-c;
    }
    public static int numOfUnplacedFruits2(int[] f, int[] b) {
        int n = f.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(b[j] >= f[i] && !set.contains(j)) {
                    set.add(j);
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}