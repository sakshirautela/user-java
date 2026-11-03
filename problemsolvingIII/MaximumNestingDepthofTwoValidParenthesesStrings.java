package problemsolvingIII;

public class MaximumNestingDepthofTwoValidParenthesesStrings {
    static void main() {
        int[] res=maxDepthAfterSplit("");
        for(int i:res){
            System.out.print(i+" ");
        }
    }
    public int[] maxDepthAfterSplit2(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int open = 0;
        int i = 0;

        for(char ch : seq.toCharArray()){
            if(ch == '('){
                open++;
                ans[i] = open % 2;
            }else{
                ans[i] = open % 2;
                open--;
            }
            i++;
        }
        return ans;
    }
        public static int[] maxDepthAfterSplit(String seq) {
            int n=seq.length();
            int [] res=new int[n];
            int a=0,b=0;
            for (int i = 0; i < n; i++) {
                if(seq.charAt(i)=='('){
                    if(a>b){
                        res[i]=1;
                        b++;
                    }else{
                        a++;
                        res[i]=0;
                    }
                }else{
                    if(a>b){
                        res[i]=0;
                        a--;
                    }else{
                        b--;
                        res[i]=1;
                    }
                }
            }
            return res;
    }
}
