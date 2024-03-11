public class subArrayCount {
    public static void main(String[] args) {
        int[] array={1,2,0,0,8,0,0};
        int count=0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==0){
                count++;
            }
            else{
                count=0;
            }
            result+=count;
        }
        System.out.println(result);
    }
}
