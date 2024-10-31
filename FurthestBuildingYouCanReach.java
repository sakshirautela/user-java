import java.util.PriorityQueue;
public class FurthestBuildingYouCanReach {
    //public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        //int result=0;
        // for(int i=0;i<heights.length-1;i++){
        //     if(heights[i]<heights[i+1] && bricks>=(heights[i+1]-heights[i])){
        //         result++;
        //         bricks-=(heights[i+1]-heights[i]);
        //     }
        //     else if(heights[i]>=heights[i+1]){
        //         result++;
        //     }
        //     else if(ladders>0){
        //         ladders--;
        //         result++;
        //     }
        //     else{
        //        return result;
        //     }
        // }
        //return result;
    //}
    public static int furthestBuilding(int[] heights, int bricks, int ladders){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int i=0;
        for ( i = 0; i < heights.length-1; i++) {
            int diff=heights[i+1]-heights[i];
            if(diff<0){
                continue;
            }
            bricks-=diff;
            pq.add(diff);
            if(bricks<0){
                bricks+=pq.remove();
                ladders--;
            }
            if(ladders<0){
                break;
            }
        }
        return i;
    }

    public static void main(String args[]){
        System.out.println(furthestBuilding(new int[]{1,5,1,2,3,4,10000},4,1));
    }
}