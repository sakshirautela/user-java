import java.util.Arrays;

public class MaximizeAreaofSquareHoleinGrid {
    static void main() {
        System.out.println(maximizeSquareHoleArea(4,5,new int[]{},new int[]{}));
    }
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h=0;
        int v=0;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int cons=0;
        h = getV(hBars, h, cons);
        v = getV(vBars, v, cons);

        return (Math.min(h,v)+2)*(Math.min(h,v)+2);
    }

    private static int getV(int[] vBars, int v, int cons) {
        for (int i = 1; i <vBars.length ; i++) {
            if(vBars[i]==vBars[i-1]+1){
                cons++;
            }else{
                v=Math.max(v,cons);
                cons=0;
            }
        }
        v=Math.max(v,cons);
        return v;
    }
}