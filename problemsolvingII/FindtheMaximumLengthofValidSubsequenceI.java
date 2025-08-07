public class FindtheMaximumLengthofValidSubsequenceI {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static int maximumLength(int[] nums) {
        int n = nums.length;
        int evenCount = nums[0] % 2 == 0 ? 1 : 0;
        int oddCount = nums[0] % 2 == 0 ? 0 : 1;
        int oddevenCount=1;
        boolean need = !(nums[0] % 2 == 0);
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                if(need) {
                    oddevenCount++;
                    need=!need;
                }
            } else {
                if(!need){
                    oddevenCount++;
                    need=!need;
                }
                oddCount++;
            }
        }
        return Math.max(evenCount, Math.max(oddCount, oddevenCount));
    }
    public int maximumLengthFast(int[] nums) {
        int[] count = new int[2]; 
        int[] end = new int[2];   

        for (int num : nums) {
            int parity = num % 2;
            count[parity]++;
            end[parity] = end[1 - parity] + 1;
        }

        return Math.max(
            Math.max(count[0], count[1]),
            Math.max(end[0], end[1])
        );
    }
}