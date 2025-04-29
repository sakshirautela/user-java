
public class SplitArrayWithXorGFG {
    public static int countgroup(int arr[]) {
        // Complete the function
        int x=0;
        for (int i : arr) {
            x^=i;
        }
        if(x!=0){
            return 0;
        }
        long a=(long) (Math.pow(2,arr.length-1)-1);
        return (int) (a%(10e9+7));
    }
    public static void main(String[] args) {
        System.out.println(countgroup(new int[]{}));
    }
}
