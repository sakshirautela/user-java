import java.util.Stack;

public class GetMinfromStack {
    /*
     * ArrayList<Integer> al;
     * int idx=-1;
     * public GetMinfromStack() {
     * al=new ArrayList<>();
     * }
     * 
     * // Add an element to the top of Stack
     * public void push(int x) {
     * // code here
     * idx++;
     * al.add(idx,x);
     * }
     * 
     * // Remove the top element from the Stack
     * public void pop() {
     * // code here
     * if(idx==-1){
     * return ;
     * }
     * al.remove(idx);
     * idx--;
     * }
     * 
     * // Returns top element of the Stack
     * public int peek() {
     * // code here
     * return al.get(idx);
     * }
     * 
     * // Finds minimum element of Stack
     * public int getMin() {
     * // code here
     * int min=Integer.MAX_VALUE;
     * for(int i=0;i<=idx;i++){
     * min=Math.min(al.get(i),min);
     * }
     * return (min==Integer.MAX_VALUE)?-1:min;
     * }
     */
    Stack<int[]> st;
    public GetMinfromStack() {
        st = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        int newMin = st.isEmpty() ? x : Math.min(x, st.peek()[1]);
        st.push(new int[]{x, newMin});
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if (!st.isEmpty()) {
            st.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        return st.isEmpty() ? -1 : st.peek()[0];
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        return st.isEmpty() ? -1 : st.peek()[1];
    }
}