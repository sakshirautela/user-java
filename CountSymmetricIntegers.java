class CountSymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low;i<=high;i++){
            String n=Integer.toString(i);
            if(n.length()%2==0){
                int ls=0;
                int l=0;            
                int rs=0;
                int r=n.length()-1;
                while(l<r){
                    ls+=Integer.parseInt(n.substring(l,l+1));
                    l++;
                    rs+=Integer.parseInt(n.substring(r,r+1));
                    r--;
                }
                if(ls==rs){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String... args) {
        System.out.println(countSymmetricIntegers(1,100));
    }
}