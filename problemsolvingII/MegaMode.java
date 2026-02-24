import java.util.Scanner;

public class MegaMode {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k=sc.nextInt();
            int[] arr = new int[n];
            int[] freq=new int[6002];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                freq[arr[i]]++;
            }
            int max=0;
            int result=0;
            for(int i=1;i<6002;i++){
                if(freq[i]!=0 && freq[i-1]!=0 && freq[i+1]!=0){
                    int a=freq[i-1]+freq[i+1];
                    if(a>k){
                        a=k;
                    }
                    if(max<freq[i]+k){
                        result=i;
                    }
                }else if(freq[i]!=0 && freq[i-1]==0 && freq[i+1]!=0){
                    int a=freq[i+1];
                    if(a>k){
                        a=k;
                    }
                    if(max<freq[i]+k){
                        result=i;
                    }
                }else if(freq[i]!=0 && freq[i-1]!=0 && freq[i+1]==0){
                    int a=freq[i-1];
                    if(a>k){
                        a=k;
                    }
                    if(max<freq[i]+k){
                        result=i;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
