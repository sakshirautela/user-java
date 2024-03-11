public class FriendaPairing {
    public static void main(String[] args) {
        System.out.println(pairs(5));
    }
    public static int pairs(int n){
        if(n==1 || n==2){
            return 1;
        }
        //int way1=pairs(n-1);
        //int ways2=pairs(n-2);
        //int totalways=(n-1)*ways2;
        //return way1*totalways;
        return (n-1)*pairs(n-1)*pairs(n-2);
    }
}
