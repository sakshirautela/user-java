import java.util.ArrayList;
import java.util.Arrays;
public class CountingElementsinTwoArrays {
    public static void main(String[] args) {
        System.out.println(countLessEq(new int[]{},new int[]{}));
    }
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        int n=a.length;
        int m=b.length;
        ArrayList<Integer> al=new ArrayList<>();
        Arrays.sort(b);
        for (int i = 0; i <n; i++) {
            al.add(getcount(b,a[i],m));
        }
        return al;
    }
    private static int getcount(int[] b, int num, int m) {
       int i=0,j=m-1;
        while (i<=j) {
            int mid=(i+j)/2;
            if(num>=b[mid]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
}