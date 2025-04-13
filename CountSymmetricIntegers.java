class CountSymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low;i<=high;i++){
            String n=Integer.toString(i);
            if(n.length()%2==0){
                int ls=0;
                int l=0;            
                int rs=0;
                int r=n.length()-1;
                while(l<r){
                    ls+=Integer.parseInt(n.substring(l,l+1));
                    l++;
                    rs+=Integer.parseInt(n.substring(r,r+1));
                    r--;
                }
                if(ls==rs){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String... args) {
        System.out.println(countSymmetricIntegers(1,100));
    }
        private static final short[] symCount = new short[10_001];
        
        
        public int countSymmetricIntegers2(int low, int high) {
            if (symCount[11] == 0)  buildCounts();
            return symCount[high] - symCount[low - 1];
        }
        
        
        // One time build of the array of how many symmetric numbers 
        // exist at or below any index value.  After the first 
        // leetcode test case, this will not be called for the 
        // remainder of the submit test cases.  The values in 
        // symCount[] will be preserved between a submit's test cases.
        private void buildCounts() {
            // Fill in 0 to 99.
            for (int num = 11; num <= 99; num++)
                symCount[num] = (short)(num / 11);
            
            // Fill in 100 to 999.  No symmetric numbers in this range 
            // since odd number of digits, to just copy the count for 
            // symCount[99].
            short prev = symCount[99];
            for (int num = 100; num <= 999; num++)
                symCount[num] = prev;
            
            // Fill in 1000 to 9999
            prev = symCount[999];
            int idx = 1000;
            for (int high10 = 1; high10 <= 9; high10++) {
                for (int high1 = 0; high1 <= 9; high1++) {
                    final int highSum = high10 + high1;
                    for (int low10 = 0; low10 <= 9; low10++) 
                        for (int low1 = 0; low1 <= 9; low1++) 
                            symCount[idx++] = (short)((highSum == low10 + low1) ? ++prev : prev);
                }
            }
            
            // Fill in 10_000.
            symCount[10_000] = symCount[9999];
        }
}