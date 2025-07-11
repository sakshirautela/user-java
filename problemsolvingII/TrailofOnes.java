public class TrailofOnes {
    public static void main(String[] args) {
        System.out.println(countConsec(5));
    }
    public static int countConsec(int n) {
        // code here
        int a=1,b=1;
        for(int i=1;i<=n;i++){
            int c=a+b;
            b=a;
            a=c;
        }
        return (1<<n)-(a);
    }
}
