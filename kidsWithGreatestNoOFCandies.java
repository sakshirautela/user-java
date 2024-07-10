import java.util.*;
public class kidsWithGreatestNoOFCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum=0;
        for(int i=0;i<candies.length;i++){
            maxNum=Math.max(maxNum,candies[i]);
        }
        List<Boolean> list=new ArrayList();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies<=maxNum){
                list.add(true);
            }
            list.add(false);
        }
        return list;
    }
    public static void main(String args[]){
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3},3));
    }
}