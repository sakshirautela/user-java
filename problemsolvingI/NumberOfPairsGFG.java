
import java.util.Arrays;

public class NumberOfPairsGFG {
    // Function to count number of pairs such that x^y is greater than y^x.
    public static long countPairs(int x[], int y[], int m, int n) {
        // code here
        Arrays.sort(x);
        Arrays.sort(y);
        int[] freq=new int[5];
        for(int a:y){
            if(a<5){
                freq[a]=freq[a]+1;
            }
        }
        int j = 0;
        long ans = 0;
        for(int i = 0; i < m; ++i){
            if(x[i] == 0) {
                continue;
            }
            if(x[i] == 1){ 
                ans += freq[0]; //ans += c + freq[1];
            }
            else{
                ans+=freq[0]+freq[1];
                while(j < n && y[j] <= x[i]){
                    ++j; 
                }
            if(j < n){ 
                ans+= n-j;
            } 
            if(x[i] == 2){
                 ans-= freq[3]; 
                 ans-= freq[4]; 
            } if(x[i] == 3)  { 
                ans+= freq[2];
            }
        }
}
        return ans;
    }
    public static void main(String args[]) {
        System.out.println(countPairs(new int[]{2, 3, 4,5},new int[]{1,2,3},4,3));
    }
}
