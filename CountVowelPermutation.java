public class CountVowelPermutation {
    public static int countVowelPermutation(int n) {
        int mod=100000007;
        long a_count=1,e_count=1,i_count=1,o_count=1,u_count=1;
        for(int rep=1;rep<n;rep++){
            long a=(e_count)%mod;            
            long e=(a_count+i_count)%mod;
            long i=(a_count+e_count+o_count+u_count)%mod;
            long u=(a_count)%mod;
            long o=(u_count+i_count)%mod;
            a_count=a;
            u_count=u;
            e_count=e;
            i_count=i;
            o_count=o;
        }
        return (int)(a_count+u_count+o_count+e_count+i_count)%mod;
    }
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(3));
    }
}