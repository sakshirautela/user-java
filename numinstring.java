public class numinstring {
    public static void main(String[] args) {
        String array[]={"zero","one","two","three","four","five","six"};
        numTostring(array, 1234);
    }
    public static void numTostring(String array[],int nums){
        if(nums==0){
            return;
        }
        int i=nums%10;
        numTostring(array, nums/10);
        System.out.print(array[i] + " ");

    }
}
