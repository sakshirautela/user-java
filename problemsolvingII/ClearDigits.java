
public class ClearDigits {
    public static void main(String[] args) {
        System.out.println(clearDigits("cb34"));
    }
    public static String clearDigits(String s) {
        StringBuilder str=new StringBuilder();
        for (int index = 0; index < s.length(); index++) {
            if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                str.deleteCharAt(str.length()-1);
            }else{
                str.append(s.charAt(index));
            }
        }
        return str.toString();
    }
}
