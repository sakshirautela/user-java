import java.util.*;

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        String str="123456789";
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j <= str.length(); j++) {
                int a=Integer.parseInt(str.substring(i,j));
                if(a>=low && a<=high) {
                    result.add(a);
                }
            }
        }
        Collections.sort(result);
        return result;
    }  
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100,1000));
    }
}
