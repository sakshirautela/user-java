class SqrtFind {
    public static int mySqrt(int x) {
        int end=x;
        int start=1;
        while(start<=end){
            int mid= start  +  (end  - start) / 2;
            System.out.println(mid);
            if(mid*mid==x){
                return mid;
            }
            else if(mid*mid>x){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return Math.round(start);
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