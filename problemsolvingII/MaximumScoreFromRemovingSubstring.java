import java.util.Stack;

public class MaximumScoreFromRemovingSubstring {
    public static void main(String[] args) {
        System.out.println(MaximumScoreFromRemovingSubstring.maximumGain("aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha", 1926, 4320));
    }

    public static int maximumGain(String s, int x, int y) {
        if (x <y){
            int temp=x;
            x=y;
            y=temp;
            s=new StringBuilder(s).reverse().toString();
        }
        int score=0,a=0,b=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='a'){
                a++;
            }else if(c=='b'){
                if(a>0){
                    a--;
                score+=x;
                }else{
                    b++;
                }
            }else{
                score+=Math.min(a,b)*y;
                a=0;
                b=0;
            }
        }
        score+=Math.min(a,b)*y;

        return  score;
    }
}
