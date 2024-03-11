class GetSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] f = new int[201];
        int[] a = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            f[nums[i] + 100]++;
            if (i >= k - 1) {
                int c = 0;
                for (int j = 0; j < 100; j++) {
                    c += f[j];
                    if (c >= x) {
                        a[i - k + 1] = j - 100;
                        break;
                    }
                }
                f[nums[i - k + 1] + 100]--;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        
    }
}
