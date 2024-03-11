import java.util.HashSet;

public class NumUniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for(String email : emails){
            uniqueEmails.add(addIgnore(email));
        }
        return uniqueEmails.size();
    }
    public static String addIgnore(String email){
        String res="";
        for(int i=0; i<email.length(); i++){
            if(email.charAt(i)=='.'){
                continue;
            }else if(email.charAt(i)=='+'){
                while(email.charAt(i)!='@'){
                    i++;
                }
            }
            if(email.charAt(i)=='@'){
                res=res+email.substring(i);
                break;
            }
            res=res+email.charAt(i);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}