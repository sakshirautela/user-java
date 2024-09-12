public class InterestingStringPuzzele {
    public static char stringPuzzle(String init, long ind) {
        // code here
        String res=init;
        String min=init;
        while(init.length()>0){
            res=min(init,init);
            init=res;
            min+=res;
        }
        return  min.charAt((int) ind-1);
    }
    public static String min(String init,String res){
        for(int i=0;i<init.length();i++){
            String sub=init.substring(0,i)+init.substring(i+1);
            res=getMinimal(res,sub);
        }
        return res;
    }
    public static String getMinimal(String s,String r){
        return ((s.compareTo(r)<0)?s:r);
    }
    public static void main(String args[]){
        System.out.println(stringPuzzle("cab",6));
    }
}