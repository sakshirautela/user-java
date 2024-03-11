public class ShortestPath {
    public static void main(String[] args) {
        String str="WNEENESENNN";
        System.out.println(sorthpath(str));
    }

    private static float sorthpath(String str) {
        int x=0;
        int y=0;
        for (int i = 0; i < str.length(); i++) {
            char dir=str.charAt(i);
            if(dir=='W' || dir=='w'){
                x--;
            }
            else if (dir == 'N' || dir == 'n') {
                y++;
            }
            else if (dir == 'S' || dir == 's') {
                y--;
            }
            else{
                x++;
            }
            
        }
        int x2=x*x;
        int y2=y*y;
        float path=(float) Math.sqrt(y2+x2);
        return path;
    }
}
