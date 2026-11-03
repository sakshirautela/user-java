public class MinimumJumps {
    public static void main(String[] args) {

        System.out.println(minJumps2(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
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

        public static int minJumps2(int[] arr) {
            // code here
            int n=arr.length;
            int jumps=0;
            int current=0;
            int range=0;
            for (int i = 0; i < n-1; i++) {
                range=Math.max(arr[i]+i,range);
                if(range>=n-1){
                    return jumps;
                }
                if(i==current){
                    current=range;
                    jumps++;
                }
            }
            return -1;
        }
}
