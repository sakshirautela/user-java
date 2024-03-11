import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Welmart {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);        
        list.add(7);       
        insert(list,list.size(),9);
        list.add(3);
        System.out.println(list);
        delete(list,list.size());
        System.out.println(list);

    }
    public static void insert(List<Integer> values,int n,int val){
        values.add(val);
        int i=n;
        while(i>0){
            int parent=i/2;
            if(values.get(parent)<values.get(i)){
                Collections.swap(values,parent,i);
                i=parent;
            }
            else{
                return;
            }
        }
    }
    public static void delete(List<Integer> values,int n){
        n=n-1;
        values.set(0,values.get(n));
        values.remove(n);
        int i=0;
        while(i<values.size()){
            int left=2*i+1;
            int right=2*i+2;
            int compare=0;
            if(right<values.size() && values.get(left)>(values.get(right))){
                compare=left;
            }
            else{
                compare=right;
            }
            if(compare<values.size() && values.get(i)<values.get(compare)){
                Collections.swap(values,compare,i);
                i=compare;
            }
            else{
                return;
            }
        }
    }
    // public static void HeapCreation(List<Integer> values){
    //     if(values.size()<=1){
    //         return;
    //     }

    // }
}
