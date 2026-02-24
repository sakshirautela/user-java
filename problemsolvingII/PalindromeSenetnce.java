import java.util.ArrayList;

public class PalindromeSenetnce {
    public static void main(String[] args) {
        System.out.println(isPalinSent("w>Y/$"));
    }

    public static boolean isPalinSent(String s) {
        // code here
        ArrayList<Character> arr = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if(ch>='A'&& ch<='Z'){
                arr.add((char) (ch|32));
            }
            else if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                arr.add(ch);
            }
        }
        int n = arr.size()-1;
        for (int i = 0; i <= n/2; i++) {
                if(arr.get(i)!=arr.get(n-i)){
                    return false;
                }
        }
        System.out.println(arr);
        return true;
    }
}
