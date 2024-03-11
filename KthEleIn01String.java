public class KthEleIn01String {
    public static int kthGrammar(int n,int k){
        if(n==1){
            return 0;
        }
        int mid=(int)Math.pow(2,n-2);
        if(k<=mid){
            return kthGrammar(n-1,mid);
        }
        else{
            return 1-kthGrammar(n-1,k-mid);
        }
    }
    public static void main(String[] args){
        System.out.println(kthGrammar(2,2));
        System.out.println((int)Math.pow(2,4));
        System.out.println((int)Math.pow(2,4-2));
    }
}