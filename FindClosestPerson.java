public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int diff1=Math.abs(z-x);
        int diff2=Math.abs(z-y);
        if(diff1<diff2){
            return 1;
        }else if(diff1>diff2){
            return 2;
        }
        else{
            return 0;
        }
    }
}