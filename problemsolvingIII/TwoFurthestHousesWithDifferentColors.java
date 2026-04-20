package problemsolvingIII;

import java.util.Arrays;
import java.util.HashMap;

public class TwoFurthestHousesWithDifferentColors {
    static void main() {
        System.out.println(maxDistance(new int[]{}));
    }
        public int maxDistanceFast(int[] colors) {
            int dis = 0;
            int n = colors.length;
            for(int i=0;i<n-1;i++){
                if(colors[i] != colors[n-1]){
                    dis = Math.max(dis ,(n-1)-i);
                    break;
                }
            }


            for(int i=n-1;i>=1;i--){
                if(colors[0]!=colors[i]){
                    dis = Math.max(dis,i);
                }
            }
            return dis;
    }
    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j =n-1; j >i; j--) {
                if (colors[i] != colors[j]) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }
}
