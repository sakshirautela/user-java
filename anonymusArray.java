public class anonymusArray {
    public static void main(String args[]){
        sum( new int[]{10,20,30,40,50});
    }
    public static void sum(int[] arr){
        int s=0;
        for(int i:arr){
            s+=i;
        }
        System.out.println("Sum is:"+s);
        //return s;
 
    }
    
}
