
class Candy {
     static {
        for (int i = 0; i < 140; ++i)
            candy(new int[] { 1, 3, 2 });
            System.gc();
    }
    public static int candyFast(int[] ratings) {
        int n=ratings.length;
        int i=1;
        int sum=1;
        while(i<n)
        {
            if(ratings[i]==ratings[i-1])
            {
                sum+=1;
                i++;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1])
            {
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while(i<n && ratings[i]<ratings[i-1])
            {
                sum+=down;
                down++;
                i++;
            }
            if(down>peak)
            {
                sum+=down-peak;
            }
        }
        return sum;
    }
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
