public class ComplementofBase10Integer {
    static void main() {
        System.out.println(bitwiseComplement(5));
    }

    public static int bitwiseComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int pow = 1;
        int result = 0;
        while (num != 0) {
            int b = num & 1;
            num = num >> 1;
            result += (pow * (b == 1 ? 0 : 1));
            pow = pow * 2;
        }
        return result;
    }
}
