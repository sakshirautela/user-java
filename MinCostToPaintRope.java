public class MinCostToPaintRope {
    public static int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int t=neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if(colors.charAt(i)!=colors.charAt(i-1)){
                t=neededTime[i];
            }else{
                cost+=Math.min(t,neededTime[i]);
                t=Math.max(t,neededTime[i]);
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        System.out.println(minCost("bbbaaa",new int[]{4,9,3,8,8,9}));
    }
}