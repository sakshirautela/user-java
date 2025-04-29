
public class MinimumStepsToTargetCoordinates {
    public static void main(String[] args) {
        System.out.println(minOperations(3,2));
    }
    static int minOperations(int x, int y) {
        // code hree
        int xcount=0;
        int ycount=0;
        x=Math.abs(x);
        y=Math.abs(y);
        if(x>=4){
            xcount+=(x/4);
            x=x%4;
        }
        if(x==2){
            x-=2;
            xcount++;
        }
        if(y>=4){
            ycount+=(y/4);
            y=y%4;
        }
        if(y==2){
            y-=2;
            ycount++;
        }
        if(x==0 && y==0){
            return xcount+ycount;
        }
        return -1;
        
    }
}
