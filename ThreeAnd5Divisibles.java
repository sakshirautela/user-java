import java.util.*;
public class ThreeAnd5Divisibles {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N=1;
        for (int a=0; a<N; a++) {
            int n = 100;
            int res=0;
            int i=5;
            int j=3;
            while(i<n && j<n){
                if(i%3==0 ){
                    i+=5;
                    continue;
                }else{
                    res+=i;
                    res+=j;
                }
                i+=5;
                j+=3;
            }
            while(j<n){
                res+=j;
                j+=3;
            }
            System.out.println(res);
        }
    }
}
