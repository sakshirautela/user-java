
public class MaximumEnergyBoostFromTwoDrinks {
    public static long maxEnergyBoost(int[] A, int[] B) {
            long A1 = 0 , B1 = 0 , A2 = 0 , B2 = 0;
            for (int i = 0 ; i < A.length ; i++){
                long currA = A[i] + Math.max(A1 , B2);
                long currB = B[i] + Math.max(B1 , A2);
                A2 = A1 ; A1 = currA;
                B2 = B1 ; B1 = currB;
            }
            return Math.max(A1 , B1);
        }
        public long maxEnergyBoost2(int[] energyDrinkA, int[] energyDrinkB) {
             int n=energyDrinkA.length;
            long dpA[]=new long[n+1];
            dpA[1]=energyDrinkA[0];
            long dpB[]=new long[n+1];
            dpA[1]=energyDrinkA[0];
            dpB[1]=energyDrinkB[0];
            for (int i = 2; i <=n ; i++) {
                dpB[i]=Math.max(dpA[i-2],dpB[i-1])+energyDrinkB[i-1];
                dpA[i]=Math.max(dpB[i-2],dpA[i-1])+energyDrinkA[i-1];
            }
            return Math.max(dpA[n],dpB[n]);
        }
        public static void main(String args[]){
        System.out.println(maxEnergyBoost(new int[]{1,3,1},new int[]{3,1,1}));
    }
}
