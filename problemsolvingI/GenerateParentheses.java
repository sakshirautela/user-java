import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisUtil(0, 0, "", res, n);
        return res;
    }

    private static void generateParenthesisUtil(int open, int close, String s, List<String> res, int n) {
        if (open == close && open + close == 2 * n) {
            res.add(s);
            return;
        }
        if (open < n) {
            generateParenthesisUtil(open + 1, close, s + "(", res, n);
        }
        if (open > close) {
            generateParenthesisUtil(open, close + 1, s + ")", res, n);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        process(sb, n, 0, result);
        return result;
    }

    private void process(StringBuffer sb, int remaining, int opened, List<String> result) {
        // options:
        // if remaining > 0 -> can open
        // if opened > - -> can close
        if (remaining == 0 && opened == 0) {
            result.add(sb.toString());
            return;
        }
        boolean needACopy = remaining > 0 && opened > 0;
        if (remaining > 0) {
            StringBuffer copy = needACopy ? new StringBuffer(sb.toString()) : sb;
            copy.append('(');
            process(copy, remaining - 1, opened + 1, result);
        }
        if (opened > 0) {
            StringBuffer copy = sb;// new StringBuffer(sb.toString());
            copy.append(')');
            process(copy, remaining, opened - 1, result);
        }

    }

}