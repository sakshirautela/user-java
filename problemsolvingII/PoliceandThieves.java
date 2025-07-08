package problemsolvingII;

public class PoliceandThieves {
public static void main(String[] args) {
        System.out.println(catchThieves(new char[] {'P' ,'T', 'T', 'P' ,'T'}, 1));
    }

    public static int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        int thieaves=0;
        boolean[] arrest=new boolean[n];
        for (int i = 0; i < n; i++) {
            int l=i-k;
            int r=i+k;
            if(arr[i]=='P'){
                for (int j = Math.max(0,l);j <Math.min(r,n); j++) {
                    if(arr[j]=='T' && !arrest[j]){
                        arrest[j]=true;
                        thieaves++;
                    }
                }
            }
        }
        return thieaves;
    }
}