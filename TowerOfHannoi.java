public class TowerOfHannoi {
    public static void tower(int n,int source,int tempHolding,int destination){
        if(n>0){
            tower(n-1,source,destination,tempHolding);
            System.out.println("source "+source+" --> "+"destination "+destination);
            tower(n - 1, tempHolding, destination, source);
        }
    }
    static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }


    public static void main(String[] args) {
        tower(3, 1, 2, 3);
    }
}
