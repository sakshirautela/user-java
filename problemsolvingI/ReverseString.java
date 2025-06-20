
import java.util.HashSet;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Vipin Bhan dar i";
        str = str.trim(); // reassign properly

        String result = "";
        String s = "";

        HashSet<Integer> hs = new HashSet<>();

        // Remove spaces and store their positions
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                hs.add(i);
            } else {
                s = s + str.charAt(i);
            }
        }

        System.out.println("String without spaces: " + s);
        System.out.println("Space positions: " + hs);

        int j = s.length() - 1; // start from end of cleaned string

        // Rebuild result
        for (int i = 0; i < str.length(); i++) {
            if (hs.contains(i)) {
                result = result + " ";
            } else {
                result = result + s.charAt(j);
                j--;
            }
        }

        System.out.println("Final result: " + result);
    }
}
