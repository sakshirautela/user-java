class DistanceTraveled {
    public static int distanceTraveled(int mainTank, int additionalTank) {
      int dist=0;
        for(int i=1;i<=mainTank;i++){
          dist+=10;
          if(i%5==0){
            mainTank++;
          }
        }
        return dist;
    }
    public static void main(String[] args) {
        System.out.println(distanceTraveled(5,10));
    }
}