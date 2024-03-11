import java.util.ArrayList;

public class Monotonic{
    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println(incmonotonic(array));
    }
    public static boolean incmonotonic(ArrayList<Integer> array){
        boolean b=true;
        boolean a = true;
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i)>=array.get(i+1)){
                b= false;
            }
            if (array.get(i) <= array.get(i + 1)) {
                a= false;
            }
        }
        return a||b;
    }
}