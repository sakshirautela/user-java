import java.util.*;
public class Permute {
    static void permute(List<Integer> arr, int k,List<List<Integer>> res){
        if (k == arr.size() -1){
            res.add(new ArrayList<>(arr));
        }
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1,res);
            Collections.swap(arr, k, i);
        }
        
    }
    public static void main(String[] args){
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        Permute.permute(Arrays.asList(1,2,3), 0, res);
        System.out.println(res);
    }
}
