import java.util.HashMap;
import java.util.Set;

public class ItineraryFromTickets {
    public static void main(String[] args) {
        HashMap<String,String> tickets=new HashMap<>();
        tickets.put("chennai", "bengalurur");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");
        String start=geStart(tickets);
        System.out.println(start);
        for (String s:  tickets.keySet()) {
            System.out.println(tickets.get(s));
            start=tickets.get(start);
        }
    }
    public static String geStart(HashMap<String,String> hm){
        HashMap<String,String> revhm=new HashMap<String,String>();
        for (String s : hm.keySet()) {
            revhm.put(hm.get(s),s);
        }
        for ( String s: hm.keySet()) {
            if(!revhm.containsKey(s)){
                return s;
            }
        }
        return null;
    }
}
