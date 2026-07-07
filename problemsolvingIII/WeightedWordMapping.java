package problemsolvingIII;

public class WeightedWordMapping {
    static void main() {
        System.out.println(mapWordWeights(new String[]{}, new int[]{}));
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for (String s : words) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += weights[c - 'a'];
            }
            sum %= 26;
            char ch = (char)((Math.abs(sum-25)) + 'a');
            str.append(ch);
        }
        return str.toString();
    }
}
