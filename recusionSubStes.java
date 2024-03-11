public class recusionSubStes {
    public static void main(String[] args) {
        recSubSet("abc","",0);
    }
    public static void recSubSet(String str,String ans,int i){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //yes choice
        recSubSet(str, ans+str.charAt(i), i+1);
        //no choice
        recSubSet(str, ans, i + 1);
    }
}
