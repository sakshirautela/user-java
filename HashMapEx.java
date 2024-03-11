import java.util.HashMap;
import java.util.Set;
public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",250); //O(1) complexity
        hm.put("china",45);
        hm.put("newZeeland",456);
        hm.put("America",23);
        hm.put("SouthK",90);
        hm.put("Brazil",57);
        hm.containsKey("china");
        System.out.println(hm.get("china"));//O(1) complexity
        System.out.println(hm.remove("china"));//O(1) complexity
        System.out.println(hm.get("china"));//O(1) complexity
        System.out.println(hm.containsKey("china"));
        System.out.println(hm);

        Set<String> keys=hm.keySet();
        for(String s:keys){
            System.out.println(s);
            System.out.println(hm.get(s));
        }
        for(int s:hm.values()){
            System.out.println(s);
            System.out.println(s);
        }

    }
}
