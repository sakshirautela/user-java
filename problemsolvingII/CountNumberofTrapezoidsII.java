import java.util.HashMap;

public class CountNumberofTrapezoidsII {
    public static void main(String[] args) {
        System.out.println(countTrapezoids(new int[][]{{-3,2},{3,0},{2,3},{3,2},{2,-3}}));
    }

    public static int countTrapezoids(int[][] points) {
        int n = points.length;
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int gcd=gcd(x,y);
                x/=gcd;
                y/=gcd;
                if(x==0){
                    y=1;
                }
                if(x<0){
                    x=-x;
                    y=-y;
                }
                String s=x+"/"+y;
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        for(int val:map.values()){
            result+=(val*(val-1))/2;
        }
        return result;
    }
    public static int gcd(int a, int b){
        if(b==0){
            return Math.abs(a);
        }
        return gcd(b,a%b);
    }
}
