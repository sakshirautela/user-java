import java.util.HashSet;

public class RestoringFishingOrder2 {
    public static void main(String[] args) {
        int[] res=recoverOrder(new int[]{},new int[]{});
    }
    public static int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:friends){
            hs.add(i);
        }
        int idx=0;
        for (int i :order) {
            if(hs.contains(i)){
                friends[idx]=i;
                idx++;
            }
        }
        return friends;
    }
}