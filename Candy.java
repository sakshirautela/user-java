class Candy {
    public static int candy(int[] ratings) {
        int[] res=new int[ratings.length];
        for(int i=0;i<res.length;i++){
            res[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                res[i]=res[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                res[i]=Math.max(res[i],res[i+1]+1);
            }
        }
        int sum=0;
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
            sum+=res[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums={1,3,4,5,2};
        System.out.println(candy(nums));
    }
}