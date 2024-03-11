import java.util.Stack;

class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int idx=0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(temperatures[0]);
        for(int i = 1; i < temperatures.length; i++) {
            if(temperatures[i]>st.peek()) {
                res[idx++]=1;
            }
            else if(temperatures[i]<st.peek()) {
                int temp = i;
                while(temp<temperatures.length && st.peek()>temperatures[temp]){
                    temp++;
                }
                if(temp==temperatures.length){
                    res[idx++] = 0;
                }
                else{
                    res[idx++] =temp-i+1;
                }
            }

            st.push(temperatures[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] temperature={ 89,62,70,58,47,47,46,76,100,70};
        int[] res = dailyTemperatures(temperature);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}