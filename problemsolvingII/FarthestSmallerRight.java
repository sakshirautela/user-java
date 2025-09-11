import java.util.ArrayList;

public class FarthestSmallerRight {
    public static void main(String[] args) {
        System.out.println(farMin(new int[]{2, 5, 1, 3, 2}));
    }
    public static  ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        int n=arr.length;
        int small=n;
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = n-1; i >=0; i--) {
            if(small==n){
                al.add(-1);
                small=i;
            }else if(arr[i]>arr[small]){
                al.add(-1);
            }else{
                al.add(small);
                small=i;
            }
        }
        return al;
    }
}
