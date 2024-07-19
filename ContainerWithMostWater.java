class ContainerWithMostWater {
    public static int maxArea(int[] height) {
      int max = 0;
      int i = 0 ;
      int j = height.length-1;
      while(i < j){
          int currea = (j-i) * Math.min(height[i], height[j]);
          max = Math.max(max, currea);
          if(height[i] < height[j]){
              i = i+1;
          }else{
              j = j -1 ;
          }
      }
      return max ;
    }
    public static void main(String[] args) {
        int[] height={ 7, 6, 4, 3, 1,6};
        System.out.println(maxArea(height));

    }
}