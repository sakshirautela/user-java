import java.util.*;
public class IsPathCrossing {
    public static boolean isPathCrossing(String path) {
        HashSet<String> hm=new HashSet();
        int x=0;
        int y=0;
        hm.add(0+""+0);
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='E') x++;
            if(path.charAt(i)=='W') x--;
            if(path.charAt(i)=='N') y++;
            if(path.charAt(i)=='S') y--;
            if(hm.contains(x+""+y)){
                return true;
            }
            hm.add(x+""+y);
        }
        System.out.println(hm);
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NESWW"));
    }
}