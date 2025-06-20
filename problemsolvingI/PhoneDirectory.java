import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PhoneDirectory {
    public static void main(String[] args) {
        System.out.println(displayContacts(4, new String[] {}, ""));
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // code here
        Arrays.sort(contact);
        ArrayList<ArrayList<String>> al = new ArrayList<>();
        String str = "";
        for (char ch : s.toCharArray()) {
            str += ch;
            displayContactsHelper(str, n, contact, al);

        }
        return al;
    }

    private static void displayContactsHelper(String str, int n, String[] contact, ArrayList<ArrayList<String>> al) {
        ArrayList<String> li = new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        if (al.size() == 0) {
            char ch = str.charAt(0);
            for (String s : contact) {
                if (s.charAt(0) == ch && !hs.contains(s)) {
                    hs.add(s);
                    li.add(s);
                }
            }
        } else {
            ArrayList<String> list = al.get(al.size() - 1);
            for (String s : list) {
                if (s.startsWith(str) && !hs.contains(s)) {
                    li.add(s);
                    hs.add(s);
                }
            }
        }

        if(li.size()==0){
            li.add("0");
        }
        al.add(li);
    }
}