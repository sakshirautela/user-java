import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class sum {
    public static void main(String[] args) {
        int[] num={6};
        int k=809;
        List<Integer> result=new ArrayList();
        // long nums=0;
        // for(int i=0;i<num.length;i++){
        //     nums=nums*10+num[i];
        //     //x=x*10;
        // }
        // long sum=0;
        // sum=nums+k;
        // while(sum>0){
        //     long rem=sum%10;
        //     //rem=(int)rem;
        //     result.add((int) rem);
        //     sum=sum/10;
        // }
        // Collections.reverse(result);
        int s=0,sum=0,rem=0;
        for(int i=num.length-1;i>=0;i--){
            rem=s%10;
            // if(carry>0){

            // }
            sum=s+num[i]+rem;
            s=sum/10;
            sum=sum%10;
            result.add(sum);
            s=s/10;
        }
        
        while(s!=0){
            s=s+s;
            rem=s%10;
            result.add(rem);
            s=s/10;
        }
        
        Collections.reverse(result);
        System.out.println(result);


        class Solution {
            public List<Integer> addToArrayForm(int[] num, int k) {
                List<Integer> result = new ArrayList<>();
                int i = num.length - 1;
                
                while (i >= 0 || k > 0) {
                    if (i >= 0) {
                        k += num[i--];
                    }
                    
                    result.add(0, k % 10);
                    k /= 10;
                }
                
                return result;
            }
        }
    }
}