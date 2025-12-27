public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(3,4));
    }
    public static int getSum(int a, int b) {
        return (int) Math.log(Math.exp(a)*Math.exp(b));
    }
}
//(a + b) = log(e^a * e^b)