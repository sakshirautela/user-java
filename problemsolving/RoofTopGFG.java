
public class RoofTopGFG {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public static int maxStep(int arr[]) {
        // Your code here
        int result=0;
        int max=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                result++;
            }else{
                max=Math.max(result,max);
                result=0;
    
            }
        }
        return (max>result)?max:result;
    }
    public static void main(String[] atgs){
        System.out.println(maxStep(new int[]{10, 11 ,2, 15 ,7, 11, 16, 19}));
    }
}
