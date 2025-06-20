
public class MissingAndRepeating {
    static int[] findTwoElement(int arr[]) {
        // code here
        int[] res=new int[2];
        int n=arr.length;
        int sum=0;
        for(int i:arr){
            sum=Math.max(i,sum);
        }
        int[] a=new int[sum+1];
        for (int i : arr) {
            a[i]++;
        }
        for (int i = 1; i < a.length; i++) {
            if(a[i]==2){
                res[0]=i;
            }
            if(a[i]==0){
                res[1]=i;
            }
        }
        if(res[1]==0){
            res[1]=n;
        }
        return res;
    }
    public static void main(String args[]) {
        int[] res=findTwoElement(new int[] { 1,3,3 });
        for(int i:res){
            System.out.println(i);
        }
    }
}
