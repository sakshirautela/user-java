import java.util.Arrays;

public class SuccessfulPairsofSpellsandPotions {
    public static void main(String[] args) {
        int[] res=successfulPairs(new int[]{5,1,3},new int[]{1,2,3,4,5},7);
        for (int i:res){
            System.out.print(i+" ");
        }
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] res=new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int r=binarySearch(spells[i],m,success,potions);
            System.out.println(r);
                res[i]=m-r;
        }
        return res;
    }

    public static  int binarySearch(int s,int n,long sucess,int[]potions){
        int i=0,j=n;
        while (i<j){
            int mid=(i+j)/2;
            if((long) potions[mid]*s>=sucess){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return i;
    }
    public int[] successfulPairsFasterAndLogical(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int max = 0;
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, potions[i]);
        }
        int[] map = new int[max + 1];
        for (int i = 0; i < n; i++) {
            map[potions[i]]++;
        }
        int sum = 0;
        for (int i = max; i >= 0; i--) {
            sum += map[i];
            map[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            int spell = spells[i];
            long index = (success + spell - 1) / spell;
            if (index <= max) {
                res[i] = map[(int) index];
            }
        }
        return res;
    }
}