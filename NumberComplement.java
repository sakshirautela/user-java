public class NumberComplement {
    public static int findComplement(int num) {
        if(num==0){
            return 1;
        }
        int bitlength=Integer.toBinaryString(num).length();
        int mask=(1<<bitlength)-1;
        return num^mask;//XOR (^)
    }
    public static void main(String args[]){
        System.out.println(findComplement(5));
    }
}