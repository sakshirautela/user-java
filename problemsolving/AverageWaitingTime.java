
public class AverageWaitingTime {
    public static double averageWaitingTime(int[][] customers) {
        double wating=0;
        double foodtime=customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            if(foodtime<customers[i][0]){
                foodtime=customers[i][0];
            }
            foodtime+=customers[i][1];
            wating+=foodtime-customers[i][0];
        }
        return wating/customers.length;
    }
    public static void main(String args[]){
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
}
