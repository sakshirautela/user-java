public class MinOperationsToBinary0101 {
    public static int minOperations(String s) {
        int count=0;//checking misplaced 
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='1'){
                    count++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    count++;
                }
            }
        }
        return Math.min(count,s.length()-count);
    }
    public static void main(String[] args) {
        System.err.println(minOperations("0101"));
    }
}