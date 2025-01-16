public class KthElementoftwoArrays {
    public static void main(String[] args) {
        System.out.println(kthElement(new int[] {}, new int[] {}, 4));
    }

    public static int kthElement(int a[], int b[], int k) {
        // code here
        int i=0;
        int j=0;
        int r=0;
        while ((i<a.length && j<b.length) && k>0) {
            if(a[i] <=b[j]){
                r=a[i];
                i++;
            }else{
                r=b[j];
                j++;
            }
            k--;
        }
        while (i < a.length && k > 0) {
            r = a[i];
            i++;
            k--;
        }
        while (j < b.length && k > 0) {
            r = b[j];
            j++;
            k--;
        }
        return r;
    }
}