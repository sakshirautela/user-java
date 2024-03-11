class Solution {
    public int isPrime(int A) {
        for(int i=2;i<A;i++){
            if(A%i!=0){
                return 1;
            }
            if(A==1){
                return 1;
            }
            
                        
        }
        return 0;
    }
}
