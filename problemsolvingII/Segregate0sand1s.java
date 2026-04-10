public class Segregate0sand1s {
    static void main() {
        int[] arr={1,1,0,0};
        segregate0and1(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    static void segregate0and1(int[] arr) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if(arr[j]==1){
                j--;
            }else if(arr[i]==0){
                i++;
            }else{
                arr[i]=0;
                arr[j]=1;
                i++;
                j--;
            }
        }
    }
}
