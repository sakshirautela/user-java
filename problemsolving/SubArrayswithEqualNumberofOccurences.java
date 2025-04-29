
public class SubArrayswithEqualNumberofOccurences {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        int xOcuur=0;
        int yOcuur=0;
        for (int i : arr) {
            xOcuur+=(i==x)?1:0;
            yOcuur+=(i==y)?1:0;
        }
        int n=arr.length;
        n-=(xOcuur+yOcuur);
        if(n==0){
            return xOcuur*yOcuur;
        }
        return (int) (Math.pow(2,n)-1);
    }
    public static void main(String[] args){
        System.out.println(sameOccurrence(new int[]{1,2,1}, 1, 2));
    }
}
