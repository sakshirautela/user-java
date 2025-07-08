import java.util.Arrays;

public class MininumSum {
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{0,0,1,2,3}));
        System.out.println(getSum(new StringBuilder("9"), new StringBuilder("3")));
    }
    static String minSum(int[] arr) {
        // code here
        int n=arr.length;
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if(i<n ){
                if(a.length()==0 && arr[i]==0){
                    continue;
                }else{
                    a.append(arr[i]);
                }
            }
            i++;
            if(i<n){
                 if(b.length()==0 && arr[i]==0){
                    continue;
                }else{
                    b.append(arr[i]);
                }
            }
        }
        return getSum(a,b);
    }
    private static String getSum(StringBuilder a, StringBuilder b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder res=new StringBuilder();
        while (i>=0 || j>=0) {
            int ai=0;
            if(i>=0){
                ai=a.charAt(i)-'0';
                i--;
            }
            int bi=0;
            if(j>=0){
                bi=b.charAt(j)-'0';
                j--;
            }
            int sum=ai+bi+carry;
            carry=sum/10;
            res.append((sum%10));
        }
        if(carry!=0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
