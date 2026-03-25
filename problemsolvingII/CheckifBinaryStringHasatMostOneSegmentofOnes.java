public class CheckifBinaryStringHasatMostOneSegmentofOnes {
    static void main() {
        System.out.println(checkOnesSegment(""));
    }

    public static boolean checkOnesSegment(String s) {
        boolean isZero = s.charAt(0) == '0';
        if (isZero) return false;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                isZero = true;
            } else if (ch == '1') {
                if (isZero) {
                    return false;
                }
            }
        }
        return true;
    }
}