public class AllocateMinimumPages {
    public static void main(String[] args) {
        System.out.println(findPages(new int[]{},3));
    }
    public static int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length)
            return -1;
        int maxLimit=0;
        int minPages=0;
        for(int i:arr){
            minPages=Math.max(minPages,i);
            maxLimit+=i;
        }
        int low=minPages;
        int high=maxLimit;
        int res=-1; 
        while(low<=high){
            int mid=(low+high)/2;
            if(check(arr,k,mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }  
        return res;     
    }
    public static boolean check(int[] arr,int k,int pageLimit){
        int count=0;
        int pageSum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+pageSum>pageLimit){
                count++;
                pageSum=arr[i];
            }else{
                pageSum+=arr[i];
            }
        }
        return (count<=k);
    }
}
