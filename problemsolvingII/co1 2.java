public class co1 {
    public static void main(String[] args) {
        System.out.println(getLeastFrequentDigit(4442));
    }
        public static int getLeastFrequentDigit(int n) {
            int[] f=new int[10];
            int freq=Integer.MAX_VALUE;
            while(n>0){
                f[n%10]++;
                n/=10;
            }
            int res=-1;
            for(int i=0;i<10;i++){
                if(f[i]>0 && f[i]<freq){
                    freq=f[i];
                    res=i;
                }
            }
            return res;
        }
}
