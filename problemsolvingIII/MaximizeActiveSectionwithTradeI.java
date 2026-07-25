package problemsolvingIII;

public class MaximizeActiveSectionwithTradeI {
    static void main() {
        System.out.println(maxActiveSectionsAfterTradeON("01"));
    }

    public static int maxActiveSectionsAfterTradeON(String s) {
        int n=s.length();
        int prev=0,curr=0,one=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                curr++;
            }else {
                if(curr!=0){
                    prev=curr;
                    curr=0;
                }
                one++;
            }
            max=Math.max(curr+prev,max);
        }
        if(max==curr || max==prev){ // checking is zero presented only one side
            return one;
        }
        return one+max;
    }
        public static int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int i = 0;
        int one = 0;
        int prev = Integer.MIN_VALUE;
        int max = 0;
        while (i < n) {
            int j=i;
            while (j<n && s.charAt(i)==s.charAt(j)){
                j++;
            }
            int len=j-i;      //length of continuous block;
            if (s.charAt(i) == '0') {
                max=Math.max(max,prev+len);
                prev=len;
            } else {
                one+=len;
            }
            i=j;
        }
        return max+one;
    }
}
