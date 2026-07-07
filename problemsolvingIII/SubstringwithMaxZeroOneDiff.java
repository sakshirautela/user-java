package problemsolvingIII;

public class SubstringwithMaxZeroOneDiff {
    static void main() {
        System.out.println(maxSubstring("11000010001"));
    }

    static int maxSubstring(String s) {
        // code here
        int max = 0;
        int sum = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0'){
                sum += 1;
            }else {
                sum -= 1;
            }
            if(sum<0){
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max==0?-1:max;
    }
}
