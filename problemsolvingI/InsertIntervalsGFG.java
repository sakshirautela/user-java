import java.util.ArrayList;
import java.util.Arrays;

public class InsertIntervalsGFG {
    static ArrayList<int[]> insertInterval(int[][] inter, int[] newInterval) {
        // code here
        int[][] newInter = new int[inter.length+1][2];
        for (int i = 0; i < inter.length; i++) {
            newInter[i] = inter[i];
        }
        newInter[inter.length]=newInterval;
        Arrays.sort(newInter,(a,b) -> a[0]-b[0]);
        ArrayList<int[]> result = new ArrayList<>();
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
        return result;  
    }
}
