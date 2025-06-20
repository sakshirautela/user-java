import java.util.ArrayList;

public class MedianofTwoSortedArraysofDifferentSizes {
    public static void main(String[] args) {
        System.out.println(medianOf2(new int[] {1,2}, new int[] {3,4}));
    }

    public static double medianOf2(int a[], int b[]) {
        // Your Code Here
        ArrayList<Integer> el=new ArrayList<>();
        findUnion(a,b,el);
        int n=el.size();
        if(n%2==1){
            return el.get(n/2);
        }else{
            System.out.println(el.get(n/2)+" "+el.get((n-1)/2));
            return (el.get(n/2)+el.get((n-1)/2))/2.0;
        }
    }

    public static void findUnion(int a[], int b[],ArrayList<Integer> al) {
        // add your code here
        int i = 0, j = 0;
        int m = a.length;
        int n = b.length;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                al.add(a[i]);
                i++;
            } else {
                al.add(b[j]);
                j++;
            }
        }
        while (i < m) {
            al.add(a[i]);
            i++;
        }
        while (j < n) {
            al.add(b[j]);
            j++;
        }
    }
}
