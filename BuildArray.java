import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class BuildArray {
    public static List<String> buildArray(int[] target, int n) {
        Stack<Integer> st = new Stack<>();        
        Stack<Integer> s = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st.push(i);
        }
        while (!st.isEmpty()) {
            s.push(st.pop());
        }
        for (int i = 0; i < target.length; i++) {
            while(s.peek() != target[i]){
                list.add("Push");                
                list.add("Pop");
                s.pop();
            }
            if(s.peek() == target[i]){
                list.add("Push");
                s.pop();
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{2,3,4},4));
    }
    
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> L = new ArrayList();
            int last = 1;
            for (int i : target) {
                for (int j = last; j < i; j++) {
                    L.add("Push");
                    L.add("Pop");
                }
                L.add("Push");
                last = i + 1;
            }
            return L;
        }
    }
}