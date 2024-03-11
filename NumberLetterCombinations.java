import java.util.*;
class NumberLetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<Character> l = new ArrayList<Character>();
        HashMap<String, String> hs = new HashMap<>();
        for (int i = 0; i < digits.length(); i++) {
            if(digits.charAt(i)=='2'){
                hs.put("2","abc");
            }
            else if(digits.charAt(i)=='3'){
                hs.put("3","def");
            }else if(digits.charAt(i)=='4'){
                hs.put("4","ghi");
            }if(digits.charAt(i)=='5'){
                hs.put("5","jkl");
            }if(digits.charAt(i)=='6'){
                hs.put("6","mno");
            }if(digits.charAt(i)=='7'){
                hs.put("7","pqrs");
            }if(digits.charAt(i)=='8'){
                hs.put("8","tuv");
            }else{
                hs.put("9","wxyz");
            }
        }
    }
    public static void main(String[] args){

    }
}