public class removeAdjustantduplicates {
    public static String removeAdjustant(String s){
        String result="";
        char curr=s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            curr=s.charAt(i);
            if(curr==s.charAt(i-1)){
                continue;
            }
            result=result+curr;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(removeAdjustant("sakshssi"));
    }
}
