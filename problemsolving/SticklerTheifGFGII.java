
public class SticklerTheifGFGII {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[] {}));
    }

    static int maxValue(int[] arr) {
        // code here
        int[] front = new int[arr.length - 1];
        for (int i = 1; i < arr.length-1; i++) {
            front[i-1]=arr[i];
        }
        int[] back = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            back[i]=arr[i];
        }
        return Math.max(maxValueHelper(front), maxValueHelper(back));
    }

    private static int maxValueHelper(int[] arr) {
        int fist=0,second=arr[0];
        for (int index = 1; index < arr.length; index++) {
            int max=Math.max(fist+arr[index],second);
            fist=second;
            second=max;
        }
        return Math.max(fist,second);
    }
}
