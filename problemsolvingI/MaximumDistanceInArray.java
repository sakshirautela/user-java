
public class MaximumDistanceInArray {
    public static int maxDistance(int[][] arrays) {
        int dist=0;
        int max=arrays[0][arrays[0].length-1];
        int min=arrays[0][0];
        for (int i = 0; i < arrays.length; i++) {
            int f=arrays[i][0];
            int l=arrays[i][arrays[i].length-1];
            dist=Math.max(dist,Math.max(max-f,l-min));
            min=Math.min(f,min);
            max=Math.max(l,min);
        }
        return dist;
    }
    public static void main(String args[]){
        System.out.println(maxDistance(new int[][]{{1,2,3},{4,5},{1,2,3}}));
    }
}
