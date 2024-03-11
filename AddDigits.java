class AddDigits {
    public static int addDigits(int num) {
        int res=num;
        while(res>9){
            num=res;
            res=0;
            while(num>0){
                int rem=num%10;
                res+=rem;
                num=num/10;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(addDigits(38));
    }
}