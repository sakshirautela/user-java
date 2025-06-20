
public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[] { 12, 0 });
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int mul = 1;
        int zero = 0;
        int idx=-1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                mul *= arr[i];
            } else {
                zero++;
                idx=i;
            }
        }
        int res[] = new int[n];
        if (zero == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = mul / arr[i];
            }
        }
        if(zero==1){
            res[idx]=mul;
        }
        return res;
    }
}
