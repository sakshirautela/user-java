import java.util.Stack;

public class reverseAstringUsingStack {
    public static void main(String[] args) {
        System.out.println(reverse("abc"));
    }
    public static String reverse(String str){
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        str="";
        while (!s.empty()) {
            char top=s.pop();
            str+=top;
        }
        return str;
    }
}
