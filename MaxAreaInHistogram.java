import java.util.Stack;

public class MaxAreaInHistogram {
    public static void main(String[] args) {
        int[] array={2,1,5,6,2,3};
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int[] result1= new int[array.length];
        int[] result2= new int[array.length];
        //left smaller //O(n)
        for (int i = 0; i < result1.length; i++) {
            while (!s1.empty() && array[s1.peek()]>=array[i]) {
                s1.pop();
            }
            if(s1.empty()){
                result1[i]=-1;
            }
            else{
                result1[i]=array[s1.peek()];
            }
            s1.push(i);
        }

        //right smaller //o(n)
        for (int i = result2.length-1; i>=0;i--) {
            while (!s2.empty() && array[s2.peek()]>=array[i]) {
                s2.pop();
            }
            if(s2.empty()){
                result2[i]=result2.length;
            }
            else{
                result2[i]=array[s2.peek()];
            }
            s2.push(i);
        }
        int maxArea=0;
        for(int i=0;i<array.length;i++){  //O(n)
            int area=(array[i])*(result2[i]-result1[i]-1);
            maxArea=Math.max(maxArea,area);
        }
        System.out.println(maxArea);
    }
}
