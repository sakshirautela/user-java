package problemsolvingIII;

public class ScoreofParentheses {
    static void main() {
        System.out.println(scoreOfParentheses("(()(()))"));
    }
        public static int scoreOfParentheses(String s) {
            int n = s.length();
            int depth = 0;
            int score = 0;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '('){
                    depth++;
                }else{
                    depth--;
                    if (s.charAt(i - 1) == '(') {
                        score += 1 << depth;
                    }
                }
            }
            return score;
        }
}
