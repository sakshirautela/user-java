import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class LetterCombinationOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        HashMap<Character,String> map=new HashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            String s=map.get(digits.charAt(i));
            for (int j = 0; j < s.length(); j++) {
                
            }
            res.add(s);
        }
        return res;
    }
    public static void main(String agrs[]){
        System.out.println(letterCombinations("23"));
    }
}