public class MinimumJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{2 ,1 ,0 ,3 ,5 ,1 ,2}));
    }

    public static int minJumps(int[] arr) {
        // code here
        int result = 1;
        int n = arr.length;
        if (arr[0] == 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        int max=arr[0];
        int steps=arr[0];
        for (int i = 1; i < n; i++) {
            if(i>=n-1){
                return result;
            }
            max=Math.max(arr[i]+i,max);
            steps--;
            if(steps==0){
                steps=max-i;
                result++;
                if(max<=i){
                    return -1;
                }
            }
        }
        return result;
    }
}
