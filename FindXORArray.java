public class FindXORArray {
    public static int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] =pref[0];
        for(int i = 1; i < pref.length; i++){
            result[i] = pref[i-1]^pref[i];
        }
        return result;
    }
    public static void main(String[] args){
        int[] ans=(findArray(new int[]{ 5, 2, 0,3 ,1}));
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}