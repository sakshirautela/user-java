import java.util.HashSet;

import java.util.Iterator;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Integer> hs=new HashSet<>();
        hs.add(5);
        hs.add(4);
        hs.add(3);
        hs.add(2);
        hs.add(1);
        hs.add(9);
        hs.add(0);
        hs.add(6);
        System.out.println(hs.contains(1));
        Iterator it=hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
