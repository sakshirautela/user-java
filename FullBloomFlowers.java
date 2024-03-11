import java.util.*;

class FullBloomFlowers {
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] result = new int[people.length];
        // HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // for(int i = 0; i < flowers.length; i++){
        //     for(int j = 0; j < people.length; j++){
        //         if(flowers[i][0] <=people[j] && people[j]<=flowers[i][1]){
        //             result[j] =result[j] + 1;
        //         }
        //     }
        // }
        // for(int i = 0; i < people.length; i++){
        //     result[i]=hm.get(people[i]);
        // }
        // Arrays.sort(flowers,(a,b)->a[0]-b[0]);
        // for (int i = 0; i < flowers.length; i++) {
        //     System.out.println(flowers[i][0]+" "+flowers[i][1]);
        // }
        // for(int i = 0; i < people.length; i++){
        //     for(int j = 0; j < flowers.length; j++){
        //         if(people[i]<flowers[j][0]){
        //             break;
        //         }
        //         else if(people[i]>=flowers[i][0] && people[i]<=flowers[j][1]){
        //             result[i]=result[i]+1;
        //         }
        //     }
        // }
        int[] blow=new int[flowers.length];
        int[] wither=new int[flowers.length];
        for(int i=0;i<flowers.length;i++){
            blow[i]=flowers[i][0];
            wither[i]=flowers[i][1];
        }
        Arrays.sort(blow);
        Arrays.sort(wither);
        for(int i=0;i<people.length;i++){
            int b=search(blow,people[i]);            
            int w=search2(wither,people[i]);
            result[i]=b-w;
        }
        return result;
    }
    private static int search(int[] blow, int i) {
        int left=0;
        int right=blow.length;
        while(left<right){
            int mid=(right+left)/2;
            if(blow[mid]<=i){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    private static int search2(int[] blow, int i) {
        int left=0;
        int right=blow.length;
        while(left<right){
            int mid=(right+left)/2;
            if(blow[mid]<i){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[][] bloomFlowers = {{1,6},{3,7},{9,11},{4,13}};
        int[] people ={2,3,7,11};
        int res[]=fullBloomFlowers(bloomFlowers,people);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}