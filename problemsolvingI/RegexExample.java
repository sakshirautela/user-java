
import java.util.regex.*;
public class RegexExample {
    static String ptr="^a.*a$|^b.*b$|^a$|^b$";
    public static void main(String[] args) {
        boolean b=Pattern.matches(ptr,"abaab");
        System.out.println(b);
    }
}
