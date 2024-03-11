public class ActivitySelection {
    public static void main(String[] args) {
        int[] start={1,3,0,5,8,5};
        int[] end={2,4,6,7,9,9};
        System.out.println(activitySelection(start,end));
    }
    public static int activitySelection(int[] start,int[] end){
        int count=1; //A0
        int curr=end[0];
        for (int i = 0; i < end.length-1; i++) {
            if(start[i+1]>=curr){
                curr=end[i+1];
                count++;
            }
        }
        return count;
    }
}
