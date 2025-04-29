
import java.util.Arrays;
import java.util.HashSet;

public class ReportSpamMassage {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String > hs=new HashSet<String>(Arrays.asList(bannedWords));
        int count=0;
        for(String s:message){
            if(hs.contains(s)){
                count++;
                if(count>=2){
                    return true;
                }
            }
        }
        return false;
    }
}
