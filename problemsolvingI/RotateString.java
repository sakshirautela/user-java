
public class RotateString {


    public static boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;
            String doubledString = s + s;
            return doubledString.contains(goal);
        }
        public static void main(String args[]){
            System.out.println(rotateString("",""));
    }
}
