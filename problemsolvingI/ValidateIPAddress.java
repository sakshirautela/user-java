
public class ValidateIPAddress {
    public static boolean isValid(String str) {
        // Write your code here
        String[] arr=str.split("\\.");
        if(arr.length<4 || arr.length>4){
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")){
                return false;
            } 
            if(arr[i].charAt(0)=='0' && arr[i].length()!=1) {
                return false;
            } 
            if(Integer.parseInt(arr[i])>255){
                return false;
            }
        }
        return true;
    }
    public static void main(String agrs[]){
        System.out.println(isValid("192.168.92.1"));
    }
}
