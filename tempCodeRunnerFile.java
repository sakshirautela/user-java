class Happy {
    public static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        int res=0;
        while(res>=1){
            int sum=0;
            while(n>0){
                int rem=n%10;
                sum+=Math.pow(rem,2);
                n=n/10;
            }
        }
        if(res==1){
            return true;
        }
        else{
           return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}