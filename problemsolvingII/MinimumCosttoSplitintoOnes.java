public class MinimumCosttoSplitintoOnes {
    static void main() {
        System.out.println(minCost(3));
    }

    public static int minCost(int n) {
        return minCostHelper(n / 2, n / 2 + n % 2);
    }

    private static int minCostHelper(int a, int b) {
        if (a == b && a==1) return 1;
        int cost=a*b;
        if(a>1){
            cost+=minCostHelper(a / 2, a / 2 + a % 2);
        }
        if(b>1){
            cost+=minCostHelper(b / 2, b / 2 + b % 2);
        }
        return cost ;
    }
}