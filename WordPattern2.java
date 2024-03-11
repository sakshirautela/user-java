import java.util.HashMap;

class WordPattern {
    public boolean wordPattern(String p, String s) {
        HashMap<String ,Character> backward=new HashMap<>();
        HashMap<Character,String> forward=new HashMap<>();
        int idx=0;
        String res="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                backward.put(res,p.charAt(idx));
                forward.put(p.charAt(idx),res);
                res="";
                idx++;
            }
            else{
                res+=ch;
            }
        }
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            if(backward.containsKey(forward.get(ch))){
                if(backward.get(forward.get(ch))!=ch){
                    return false;
                }
            }
            else if(!backward.containsKey(forward.get(ch))){
                    return false;
            }
        }
        return true;
    }   
}