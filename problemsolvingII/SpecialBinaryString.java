import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    static void main() {
        System.out.println(makeLargestSpecial("11001100"));
    }

    public static String makeLargestSpecial(String s) {
        int n = s.length();
        int i=0;
        int count=0;
        List<String> li=new ArrayList<>();
        for (int j=0;j<n;j++){
            if (s.charAt(j)=='1'){
                count++;
            }else{
                count--;
            }
            if(count==0){
                li.add("1"+makeLargestSpecial(s.substring(i+1,j))+"0");
                i=j+1;
            }
        }
        li.sort(Collections.reverseOrder());
        return String.join("", li);
    }
}