import java.util.ArrayList;

public class SearchPatternRabinKarpAlgorithm {
    public static void main(String[] args) {
        System.out.println(search("", ""));
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // Code here
        int d = 256;
        // A prime number for modulo operations to reduce collisions
        int q = 101;
        // Length of the pattern
        int M = pat.length();
        // Length of the text
        int N = txt.length();
        // Hash value for pattern
        int p = 0;
        // Hash value for current window of text
        int t = 0;
        // High-order digit multiplier
        int h = 1;
        // ArrayList to store result indices
        ArrayList<Integer> ans = new ArrayList<>();

        // Precompute h = pow(d, M-1) % q
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Compute initial hash values for pattern and first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {

            // If hash values match, check characters one by one
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    ans.add(i + 1); // 1-based indexing
            }

            // Calculate hash value for the next window
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // Ensure hash value is non-negative
                if (t < 0)
                    t += q;
            }
        }

        return ans;
    }
    static ArrayList<Integer> search2(String pat, String txt) {

     int[] pattern=new int[pat.length()+1];
        for(int i=1,s=0;i<pat.length();){
            if(pat.charAt(i)==pat.charAt(s)){
                pattern[i]=++s;
                i++;
            }else if(s>0) s=pattern[s-1];
            else i++;
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0,s=0;i<txt.length();i++){
            if(txt.charAt(i)==pat.charAt(s)) s++;
            else{
                while(s>0){
                    s=pattern[s-1];
                    if(txt.charAt(i)==pat.charAt(s)){
                        s++;
                        break;
                    }
                }
            }
            if(s==pat.length()){
                list.add(i-s+2);
                s=pattern[s-1];
            }
        }
        
        return list;
        
    } 
}