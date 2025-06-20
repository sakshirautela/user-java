
public class ShifftingLetters {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[] { 3 ,5,9}));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        long cumulativeShift = 0;
        char[] chars = s.toCharArray();
        
        for (int i = shifts.length - 1; i >= 0; --i) {
            cumulativeShift += shifts[i];
            chars[i] = (char) ((chars[i] - 'a' + cumulativeShift) % 26 + 'a');
        }

        return new String(chars);

    }
}
