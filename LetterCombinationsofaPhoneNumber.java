import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> combination=new ArrayList<>();
        HashMap<Character, String> latters = new HashMap<>();
            latters.put('2', "abc");
            latters.put('3', "def");
            latters.put('4', "ghi");
            latters.put('5', "jkl");
            latters.put('6', "mno");
            latters.put('7', "pqrs");
            latters.put('8', "tuv");
            latters.put('9', "wxyz");
        letterCombinationsUtil(digits,0,digits.length(),new StringBuilder(),combination,latters);
        return combination;
    }
    private static void letterCombinationsUtil(String digits, int i,int n, StringBuilder str, List<String> combination, HashMap<Character,String> latters) {
        if(i==n){
            combination.add(str.toString());
            return;
        }
        for(char ch:latters.get(digits.charAt(i)).toCharArray()){
            str.append(ch);
            letterCombinationsUtil(digits, i+1, n, str, combination,latters);
            str.deleteCharAt(str.length()-1);
        }
    }
}