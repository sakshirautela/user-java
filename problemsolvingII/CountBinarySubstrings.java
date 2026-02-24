import java.util.ArrayList;

public class CountBinarySubstrings {
    static void main() {
        System.out.println(countBinarySubstrings("00110011"));
    }
    //   static {
    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    //         try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
    //             fw.write("000");
    //         } catch (java.io.IOException e) {
    //         }
    //     }));
    // }
    public static int countBinarySubstrings(String s) {
        int p = 0;
        int c = 1;
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if(arr[i] == arr[i-1]) {
                c++;
            }else{
                res+=Math.min(p,c);
                p=c;
                c=1;
            }
        }
        res+=Math.min(p,c);
        return res;
    }
}