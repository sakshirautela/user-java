import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InsertIntervals {
    public static int[][] insert(int[][] inter, int[] newInterval) {
        if(inter.length==0){
            return (new int[][]{{newInterval[0],newInterval[1]}});
        }
        int[][] newInter = new int[inter.length+1][2];
        for (int i = 0; i < inter.length; i++) {
            newInter[i] = inter[i];
        }
        newInter[inter.length]=newInterval;
        Arrays.sort(newInter,(a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        result .add(new int[]{newInter[0][0],newInter[0][1]}); 
        for (int i = 0; i < newInter.length; i++) { 
            System.out.println(newInter[i][0] + "," + newInter[i][1]+" ");
        }
        for (int i = 1; i < newInter.length; i++) { 
            if(result.get(result.size()-1)[1]>=newInter [i][0]){
                int end = Math.max(result.get( result.size()-1)[1],newInter[i][1]);                
                int start = Math.min(result.get(result.size()-1)[0],newInter[i][0]);
                result.remove(result.size()-1);
                result.add(new int[]{start,end});  
            }    
            else{    
                result.add(new int[]{newInter[i][0],newInter[i][1]});
            }
        }         
        return result.toArray(new int[result.size()][]);   
    }

    
    public static void main(String[] args )  {                       
        int[][] intervals = {{1,2} ,{ 3,5 },{6,8},{8,10},{12,15}};
        int[] newInterval = {6,8};
        int res[][] = insert(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + "," + res[i][1]+" ");
        }
        System.out.println();
    }
}