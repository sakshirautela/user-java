import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] stocks={100,80,60,70,60,85,100};
        int[] span=new int[stocks.length];
        stockSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
        
    }
    public static void stockSpan(int[] stock,int[]span){
        Stack<Integer> s=new Stack<>();
        s.push(0);
        span[0]=1;
        for (int i = 1; i < stock.length; i++) {
            int curr=stock[i];
            while(!s.empty() && curr>stock[s.peek()] ){
                s.pop();
            }
            if(s.empty()){
                span[i]=i+1;
            }
            else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }
}
