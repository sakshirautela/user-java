public class MinimumNumberofSwapstoMaketheStringBalanced {
    public static int minSwaps(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                res++;
            }else{ 
                if(res>0) res--;
            }
        }
        return (res+1)/2;
    }
    public static void main(String args[]) {
        System.out.println(minSwaps(""));
    }
}