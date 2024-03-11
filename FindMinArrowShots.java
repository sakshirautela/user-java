import java.util.Arrays;

class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        if(points.length<=1){
            return points.length;
        }
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        for (int i=0;i<points.length;i++){
            System.out.println(points[i][0] + "," + points[i][1]+" ");

        }
        int compare=Integer.MAX_VALUE;
        int shots=1;
        for (int i=0;i<points.length;i++) {
            if(points[i][0]>compare){
                compare=points[i][1];
                shots++;
            }
            compare=Math.min(compare,points[i][1]);
        }
        return shots;

    }
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{-2147483646,-2147483645 } ,{ 2147483646,2147483647 } }));
    }
}