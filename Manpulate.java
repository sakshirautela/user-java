import java.util.List;
import java.util.ArrayList;

public class Manpulate {
    public static void main(String[] args) {
        int n= 5;
        getBit(n,2);
        System.out.println(div(5, 1));
        System.out.println(count(n, 0));        
        System.out.println(getInt(n));
    }
    public static void getBit(int n,int pos){
        if(((1<<pos) & n)==1){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
    public static int div(int a, int b){
        int ans=b>>a;
        return ans;
    }
    public static List<Integer> getInt(int n){
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<=n;i++){
            ans.add(count(i,0));
        }
        return ans;

    }
    public static int count(int n,int freq){
        while (n!=0) {
            n=(n & (n-1));
            freq++;
        }
        return freq;
    }
}
