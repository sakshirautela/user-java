
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class AddById {
    static class prop{
        int id;
        int val;
        public prop(int id,int val){
            this.id=id;
            this.val=val;
        }
    }
    public static void main(String[] args){
        List<prop> list=new ArrayList<prop>();
        list.add(new prop(1,2));
        list.add(new prop(1,2));
        list.add(new prop(1,2));
        list.add(new prop(1,2));
        System.out.println(addById(list));
    }
    private static HashMap<Integer,Integer> addById(List<prop> list) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(prop i:list){
            hm.put(i.id,hm.getOrDefault(i.id,0)+i.val);
        }
        return hm;
    }
}
