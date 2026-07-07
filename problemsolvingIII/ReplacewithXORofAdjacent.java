package problemsolvingIII;

public class ReplacewithXORofAdjacent {
    static void main() {
        int[] arr={2, 1, 4, 7};
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        replaceElementsWithoutON(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void replaceElementsWithoutON(int[] arr) {
        // code here
        int n=arr.length;
        int prev=arr[0];
        for(int i=0;i<n;i++){
            if(i==0){
                arr[0]=prev^arr[1];
            }else if(i==n-1){
                arr[n-1] = prev ^ arr[n-1];
            } else {
                int a=prev^arr[i+1];
                prev=arr[i];
                arr[i]=a;
            }
        }
    }
        public static void replaceElements(int[] arr) {
            // code here
            int n=arr.length;
            int[] prev=new int[n];
            for(int i=0;i<n;i++){
                if(i==0){
                    prev[0]=arr[0]^arr[1];
                }else if(i==n-1){
                    prev[n-1] = arr[n-2] ^ arr[n-1];
                } else {
                    prev[i]=arr[i-1]^arr[i+1];
                }
            }
            for(int i=0;i<n;i++){
                arr[i]=prev[i];
            }
        }
}
