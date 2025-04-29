
public class CountVowelSubstrings {
    public static void main(String args[]) {
        String word="aeiouu";
        System.out.println(countVowelSubstrings(word));
    }
    public static int countVowelSubstrings(String word) {
        int count=0;
        String str="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='o' || word.charAt(i)=='i' || word.charAt(i)=='u'){
                str+=word.charAt(i);
            }else{
                if(str.length()>=5){
                    count+=getSubCount(str,0);
                }
                str="";
            }
        }
        count+=getSubCount(str,0);
        return count;
    }
    private static int getSubCount(String str,int count) {
        String result="";
        for(int i=0;i<str.length();i++){
            for(int j=i+5;j<=str.length();j++){
                result=str.substring(i,j);
                System.out.println(result);
                //System.out.println(result);
                if(result.contains("a") && result.contains("i") && result.contains("o")&& result.contains("e") && result.contains("u")){
                    count++;
                }
            }
        }
        return count;
    }
}
