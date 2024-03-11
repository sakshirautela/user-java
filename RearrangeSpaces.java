import java.util.List;

import java.util.ArrayList;

class RearrangeSpaces {
    public static String reorderSpaces(String text) {
        int n=0;
        int w=0;
        String res="";
        List<String> lines = new ArrayList<String>();
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i)==' ' && !res.equals("")){
                w++;
                n++;
                lines.add(res);
                res="";
            }
            else if(text.charAt(i)==' ' && res.equals("")){
                n++;
            }
            else{
                res=res+text.charAt(i);
            }
        }
        if (res != "") {
            lines.add(res);
            w++;
        }
        res="";        
        String t="";
        int sp=n/(w-1);
        while(sp>0){
            t+=" ";
            sp--;
        }
        for(int i=0;i<lines.size()-1;i++){
            res=res+lines.get(i)+t;
        }
        return res+lines.get(lines.size()-1)+"@"; 
    }
    public static void main(String[] args){
        System.out.println(reorderSpaces(" practice   makes   perfect"));
    }
}