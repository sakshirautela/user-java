
public class JumpingGame {
    public static long[] jumpGame(int n, int[] d, int[] c) {
        long[] res = new long[n];
        
        // Initialize the last element to 0
        res[n - 1] = 0;
        
        // Calculate res array (from the end to the start)
        for (int i = n - 2; i >= 0; i--) {
            int nextIndex = i + d[i];
            if (nextIndex >= n) {
                res[i] = -1;
            } else {
                res[i] = c[i] + res[nextIndex];
            }
        }
        
        // for (int i = 1; i < n; i++) {
        //     int prevIndex = i - d[i];
        //     if (prevIndex < 0) {
        //         if (res[i] == -1) {
        //             res[i] = -1; 
        //         }
        //     } else if (res[i] == -1 || (res[i] == 0 && i!=n-1)) {
        //         res[i] = c[i] + res[prevIndex]; 
        //     } else {
        //         res[i] = Math.min(res[i], c[i] + res[prevIndex]); // Take the minimum cost of both calculations
        //     }
        // }
        return res;
    }                
    public  static  void  main(String[] args){
        long[] res=jumpGame(5,new int[]{4 ,1 ,1 ,2 ,1},new int[]{1 ,2 ,1 ,7 ,4});// res 1 3 4 10 0
        for(long l:res){
             System.out.println(l);
        }
    }
}
