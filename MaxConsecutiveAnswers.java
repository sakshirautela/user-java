import java.util.HashMap;

class MaxConsecutiveAnswers {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int ans= helper(answerKey,answerKey,k,hm);
        System.out.println(hm);
        return ans;
    }
    public static int helper(String str,String res,int k, HashMap<String, Integer> hm){
        if(k==0){
            return 0;
        }
        int count = 0;
        int rest=0;
        if(hm.containsKey(res)){
            rest = hm.get(res);
        }
        for(int i=0;i<res.length();i++){
            String mf="";
            if(res.charAt(i)=='F'){
                mf=res.substring(0,i)+'T'+res.substring(i+1);
            }
            else{
                mf=str.substring(0,i)+'F'+str.substring(i+1);            
            }
            count=cosicutiveCount(mf);
            rest=Math.max(helper(res,mf,k-1,hm),Math.max(rest,count));
            hm.put(mf, rest);
        }
        return rest;
    }
    private static int cosicutiveCount(String str) {
        int count=0;
        int sum=1;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==str.charAt(i-1)){
                sum++;
            } 
            else{
                count=Math.max(sum,count);
                sum=1;
            }           
        }
        count=Math.max(sum,count);
        return count;

    }
    public static void main(String[] args) {
        String answerKey="TFFT";
        System.out.println(maxConsecutiveAnswers(answerKey,12));       
        System.out.println(cosicutiveCount("TTFTTFTT"));
    }
}