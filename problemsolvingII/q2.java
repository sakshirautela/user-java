public class q2 {
    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(2, 3));
    }

    public static String maxSumOfSquares(int num, int sum) {
        if(sum>(num*9)){
            return "";
        }
        int nine=sum/9;
        int rem=sum-(nine*9);
        StringBuilder sb=new StringBuilder();
        while (nine>0){
            sb.append('9');
            nine--;
        }
        if(rem>0){
            sb.append(rem);
        }
        while (sb.length()<num){
            sb.append('0');
        }
        return sb.toString();
    }
}
