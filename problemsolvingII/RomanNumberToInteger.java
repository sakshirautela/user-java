import java.util.HashMap;

public class RomanNumberToInteger {
    public static void main(String[] args) {
        System.out.println(romanToDecimal("M"));
    }

    public static int romanToDecimal(String s) {
        // code here
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        for (int i = 0; i < n-1; i++) {
            int curr=map.get(s.charAt(i));
            int next=map.get(s.charAt(i+1));
                if (curr<next) {
                    num -=curr;
                }
            else {
                num += curr;
            }
        }
        num+=map.get(s.charAt(n-1));
        return num;
    }
}
