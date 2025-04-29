
import java.util.Arrays;
import java.util.List;

class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for (int i = 1; i*2 <= n; i++) {
                System.out.println(s.substring(0, i));
                if(isRepeated(n, s, s.substring(0,i),i)){
                    return true;
                }
                System.out.println();
        }
        return false;
    }
    private static boolean isRepeated(int n,String s,String sub,int len){
        int i=len;
        while(i+len<=n){
            System.out.print(sub+" "+s.substring(i, i+len)+" ");
            if(!sub.equals(s.substring(i, i+len))){
                return false;
            }
            i+=len;
        }
        if(i<n){
            if(!sub.equals(s.substring(i, n))){
                return false;
            }
        }
        return true;
    }
    static Integer[] primes = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
            79, 83, 89, 97, 101, 103, 107, 109, 113 };
    public static boolean repeatedSubstringPattern2(String s) {
        List<Integer> primeNumbers = Arrays.asList(primes);
        int n = s.length();
        for (Integer prime : primeNumbers) {
            int size = n / prime;
            if (size < 1) {
                return false;
            }
            if (n % size == 0) {
                boolean sol = true;
                String substring = s.substring(0, size);
                for (int i = 1; size * (i + 1) <= s.length(); i++) {
                    String part = s.substring(size * i, size * (i + 1));
                    if (!substring.equals(part)) {
                        sol = false;
                        break;
                    }
                }
                if (sol == true) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(repeatedSubstringPattern("babbabbabbabbab"));
    }
}
