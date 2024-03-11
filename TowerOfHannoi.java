public class TowerOfHannoi {
    public static void tower(int n,int source,int tempHolding,int destination){
        if(n>0){
            tower(n-1,source,destination,tempHolding);
            System.out.println("source "+source+" --> "+"destination "+destination);
            tower(n - 1, tempHolding, destination, source);
        }
    }
    public static void main(String[] args) {
        tower(3, 1, 2, 3);
    }
}
