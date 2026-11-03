package problemsolvingIII;

public class MinimumCostforNCharacters {
    static void main() {
        System.out.println(minCost(2,3,2,4));
    }
    public static int minCost(int n, int i, int d, int c) {
        // code here
       return  i+minCostHelper(n,i,d,c,1);
    }
    public static int minCostHelper(int n,int i,int d,int c,int len) {
        if(len>n){
            return Integer.MAX_VALUE;
        }
        if(len==n){
            return 0;
        }
        return Math.min(i+minCostHelper(n,i,d,c,len+1),Math.min(d+minCostHelper(n,i,d,c,len-1),c+minCostHelper(n,i,d,c,len*2)));
    }
}
