public class TrappingRainWater {
    // public void maxLeft(int[] bar){
    //     int[] maxArray= new int[bar.length];
    //     int max=Integer.MIN_VALUE;
    //     for (int i = 0; i < bar.length; i++) {
    //         if(max<bar[i]){
    //             max=bar[i];
    //             maxArray[i]=max;
    //         }
    //         maxArray[i]=max;
    //     }
    //     //return maxArray;
    // }

    // public int[] maxRight(int[] bar) {
    //     int[] Array = new int[bar.length];
    //     int max = Integer.MIN_VALUE;
    //     for (int i= bar.length-1;i>=0; i--) {
    //         if (max < bar[i]) {
    //             max = bar[i];
    //             Array[i] = max;
    //         }
    //         Array[i] = max;
    //     }
    //     return Array;
    // }
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        //leftmax
        int[] maxArray = new int[height.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxArray[i] = max;
            }
            maxArray[i] = max;
        }
        // rightmax
        int[] Array = new int[height.length];
        int maxright = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            if (maxright < height[i]) {
                maxright = height[i];
                Array[i] = maxright;
            }
            Array[i] = maxright;
        }
        
        int min=0;
        int vol=0;
        for (int i = 0; i < Array.length; i++) {
            min=Math.min(Array[i], maxArray[i]);
            vol=vol+min-height[i];
        }
        System.out.println(vol);
        
    }
}
