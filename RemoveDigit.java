//2259. Remove Digit From Number to Maximize Result
public class RemoveDigit{
    public static void main(String[] args) {
        String number="14234";
        char digit='4';
        System.out.println(removeDigit(number,digit));
        //removeDigit(number,digit);
    }
    public static String removeDigit(String number, char digit) {
        int idx=number.indexOf(digit);
        // String s=digit;
        System.out.println(idx);
        //String res=number.replace(Character.toString(digit),"");
        //return res;
        //return number.substring(0,idx-1)+number.substring(idx+1,number.length()-1);
        StringBuilder res= new StringBuilder(number);
        res.deleteCharAt(idx);
        return res.toString();

    }
}