public class Countjumps {
    public static void main(String ...args){
            int[] nums={2,3,0,1,4};
            int length = nums.length;
            int[] distances = new int[length];
            int jumps = 0;
    
            for (int i = 0; i < length; i++) {
                while (i > distances[jumps]) {
                    jumps++;
                }
                
                if (jumps < length - 1) {
                    distances[jumps + 1] = Math.max(distances[jumps + 1], i + nums[i]);
                }
            }
    
    
            System.out.println(jumps);
        }
    
    
}
