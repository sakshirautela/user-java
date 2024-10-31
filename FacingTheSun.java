public class FacingTheSun {
    // Returns count buildings that can see sunlight
    public static int countBuildings(int[] height) {
        // code here
        int facing=height[0];
        int res=1;
        for(int i:height){
            if(i>facing){
                res++;
                facing=i;
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(countBuildings(new int[]{}));
    }
}