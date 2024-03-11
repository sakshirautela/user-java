class MinStack {
    static int top=-1;
    int n=10;
    int[] st;
    public MinStack() {
       st=new int[n];
    }
    
    public void push(int val) {
        if(top!=n-1){
            top++;
            st[top]=val;
        }
    }
    
    public void pop() {
        if(top!=-1){
            top--;
        }
    }
    
    public int top() {
        return st[top];
    }
    
    public int getMin() {
        if(top!=-1){
            int minval=st[top];
            for (int i = top-1; i>=0; i--) {
                if(st[i]<minval){
                    minval=st[i];
                }
            }
            return minval;
        }
        else{
            throw new RuntimeException("empty");
        }
    }
    public static void main(String[] args) {
        /**
         * Your MinStack object will be instantiated and called as such:*/
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);       
        minStack.push(0);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.getMin()); // return -2
        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */