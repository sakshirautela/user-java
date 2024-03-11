public class BinaryString {
    public static void main(String[] args) {
        binaryString(3,"",0);
    }
    
    public static void binaryString(int n,String str,int lastPlace){
        if(n==0){
            System.out.println(str);
            return;
        }
        //work to perform
        if(lastPlace==0){
            binaryString(n - 1, str+"0", 0);
            binaryString(n - 1, str+"1", 0);

        } 
        else{
            binaryString(n - 1, str + "0", 1);

        }
    }
}
