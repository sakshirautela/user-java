public class sdd {
    static void main() {
        System.out.println(countVisiblePeople(3,1,0));
    }
    public static int countVisiblePeople(int n, int pos, int k) {
        int r = n - pos - 1;
        long ans = 0;
        for (int s = 0; s <= k; s++) {
            if (s < pos && k - s <= r) {
                long w = (ways(pos, s) * ways(r, k - s)) % mod;
                ans = (ans + w) % mod;
            }
        }
        if(ans==0){
            return 2;
        }
        ans=(ans*2) % mod;
        return Math.toIntExact(ans);
    }
static int mod = (int)1e9 + 7;
    private static long ways(int n, int r) {
        long ans = 1;
        for(int i=n;i>Math.max(r,n-r);i--){
            ans*=i;
        }
        for(int j=2;j<=Math.max(r,n-r);j++){
            ans/=j;
        }
        return ans;
    }
}