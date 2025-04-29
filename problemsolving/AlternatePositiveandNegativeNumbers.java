
import java.util.ArrayList;
import java.util.Arrays;
public class AlternatePositiveandNegativeNumbers {
    static void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> postive=new ArrayList<Integer>();
        ArrayList<Integer> negative=new ArrayList<Integer>();
        for(int i:arr){
            if(i>=0){
                postive.add(i);
            }else{
                negative.add(i);
            }
        }
        int i=0;
        int idx=0;
        int j=0;
        while(idx<arr.size()){
            if(i<postive.size()){
                arr.remove(idx);
                arr.add(idx,postive.get(i));
                i++;
                idx++;
            }if(j<negative.size()){
                arr.remove(idx);
                arr.add(idx,negative.get(j));
                j++;
                idx++;
            }

        }
    }
    public static void main(String args[])
    {
        ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2));
        rearrange(al);
        System.out.println(al);

    }
}
