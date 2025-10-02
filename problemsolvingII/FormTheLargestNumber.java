import java.util.Arrays;

public class FormTheLargestNumber {
    public static void main(String[] args) {
        System.out.println(findLargest(new int[]{2400 ,31798 ,0}));
    }
    public static String findLargest(int[] arr) {
        // code here
        int n=arr.length;
        String[] str=new String[n];
        for (int i = 0; i < n; i++) {
            str[i]=Integer.toString(arr[i]);
        }
        Arrays.sort(str,(a,b)->(a+b).compareTo(b+a)>0?1:-1);
        StringBuilder s =new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            s.append(str[i]);
        }
        return (s.charAt(0)=='0')?"0":s.toString();
    }
}