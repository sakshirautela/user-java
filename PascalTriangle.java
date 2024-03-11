import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> getRow(int rowIndex) {
        List<List<Integer>> dp=new ArrayList<List<Integer>>();
        for(int i=0;i<rowIndex;i++){
            dp.add(new ArrayList());
            dp.get(i).add(1);
        }
        for(int i=0;i<rowIndex;i++){
            for(int j=1;j<rowIndex;j++){
                if(i==j){
                    dp.get(i).add(1);
                }
                else if(i>j){
                    dp.get(i).add(j,dp.get(i-1).get(j-1)+dp.get(i-1).get(j));
                }
            }
        }
        return dp;
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            res.add(genRow(i));
        }
        return res;
    }

    public List<Integer> genRow(int row){
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i < row; i++){
            ans = ans * (row - i);
            ans = ans / i;
            list.add(ans);
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println(getRow(5));
    }
}