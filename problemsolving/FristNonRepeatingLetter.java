public class FristNonRepeatingLetter {
    public int firstUniqChar(String s) {
        int idx=Integer.MAX_VALUE;
        int count[]=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(int i=0;i<count.length;i++){
            char ch=(char)(i+'a');
            if(count[i]==1 && s.indexOf(ch)<idx){
                idx=s.indexOf(ch);
            }
        }
        return (idx==Integer.MAX_VALUE?-1:idx);
    }
    public static void main(String[] args) {
        
    }
}