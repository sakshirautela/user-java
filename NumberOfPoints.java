import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class NumberOfPoints {
    public static int numberOfPoints(List<List<Integer>> nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int result=0;
        Collections.sort(nums,(a,b)->a.get(0)-b.get(0));
        System.out.println(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            if(res.size()!=0 && nums.get(i).get(0) <= res.get(res.size()-1).get(1)){
                int a=Math.max(res.get(res.size()-1).get(1),nums.get(i).get(1));               
                int b=Math.min(nums.get(i).get(0),res.get(res.size()-1).get(0));
                if(res.size()!=0){
                    res.remove(res.size()-1);
                }
                res.add(new ArrayList<>(List.of(b,a)));
            }
            else {
                res.add(new ArrayList<>(List.of(nums.get(i).get(0),nums.get(i).get(1))));
            }
        }
        System.out.println(res);
        for(int i=0;i<res.size();i++){
            max=res.get(i).get(1);
            min=res.get(i).get(0);
            result=result+(max-min+1);
        }
        return result;
    }
    public static void main(String[] args){
        List<List<Integer>> list=new ArrayList();
        list.add(new ArrayList<>(List.of(2,3)));       
        list.add(new ArrayList<>(List.of(3,9)));       
        list.add(new ArrayList<>(List.of(5,7)));       
        list.add(new ArrayList<>(List.of(4,10)));       
        list.add(new ArrayList<>(List.of(9,10)));       
        System.out.println(numberOfPoints(list));
    }
    public int numberOfPoints2(List<List<Integer>> nums) {
        boolean vis[] = new boolean[101];
        for(List<Integer> ll:nums)
        {
            int i = ll.get(0);
            int j = ll.get(1);
            while(i<=j)
            {
                vis[i] = true;
                i++;
            }
        }
        int count = 0;
        for(boolean b:vis)
            if(b)
                count++;
        return count;
    }
}