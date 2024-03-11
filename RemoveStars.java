import java.util.Stack;

class RemoveStars {
    public static void main(String[] args) {
        System.out.println(removeStars2("leet**cod*e*"));
    }
    public static String removeStars(String s) {
        Stack<Character> stack=new Stack();
        String str="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='*' && !stack.isEmpty()){
                stack.pop();
            }
            else if(ch!='*'){
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            str=stack.pop()+str;
        }
        return str;
    }

    public static String removeStars2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        char[] a = new char[n];
        int k = 0;
        for (char c : chars) {
            if (c == '*') {
                if (k > 0)
                    k--;
            } else {
                a[k++] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(a[i]);
        }
        return sb.toString();
    }
}