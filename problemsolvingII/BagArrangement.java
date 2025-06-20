import java.util.*;

public class BagArrangement {
    // Placeholder for user logic function
    public static int user_logic(String s) {
        // User will write their logic here
        int res=0;
        HashMap<Character,Integer> hs=new HashMap<>();
        for(char ch:s.toCharArray()){
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        boolean isOdd=false;
        for(char ch:hs.keySet()){
            if(hs.get(ch)%2==1){
                isOdd=true;
                res+=hs.get(ch)-1;
            }else{
                res+=hs.get(ch);
            }
        }
        if(isOdd){
            res+=1;
        }
        return res;  // Placeholder return value
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        // Call user logic function and print the output
        int result = user_logic(s);
        System.out.println(result);
        scanner.close();
    }
}