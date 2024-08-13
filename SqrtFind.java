class SqrtFind {
    public static long mySqrt(int n) {
        long low = 0;
        long high = n;
        long ans = 0; 

        while(low <= high){
          
            long mid = low + (high - low) / 2;
            
          
            if((mid * mid) <= n){
                ans = mid;        
                low = mid + 1;
            }
            
            else if((mid * mid) > n){
                high = mid - 1;    
            }
        }
        return ans;
    }
    public static int mySqrt2(int x){
        int result=-1;
        for(int i=1;i<x/2;i++){
            if(x-(i*i)>=0){
                result= i;
            }else{
                break;
            }
        }
        return result;
    }
    
    public int mySqrt3(int x) {
        long i = 2;
        if (x == 0) {
            return 0;

        } else if (x == 1) {
            return 1;
        } else {
            while (i * i <= x) {
                i++;
            }
        }
        return (int) i - 1;

    }
    public static void main(String[] args){
        System.out.println(mySqrt2(12));
    }
}