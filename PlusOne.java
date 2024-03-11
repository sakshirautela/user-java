import java.util.ArrayList;
import java.util.Collections;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        int i=digits.length-1;
        int sum=1;
        ArrayList<Integer> result = new ArrayList();
        while(i>=0 || sum>0){
            if(i>=0){
                sum+=digits[i];
                i--;
            }
            result.add(sum%10);
            sum=sum/10;
        }
        Collections.reverse(result);
        int[] res= new int[result.size()];
        for(int j=0;j<result.size();j++){
            res[j]=result.get(j);
            System.out.println(res[j]);

        }
        
    }
}
class Solution {
    public int[] plusOne(int[] digits) {

     for (int i = digits.length - 1; i >= 0; i--) {
	if (digits[i] < 9) {
		digits[i]++;
		return digits;
	}
	digits[i] = 0;
}

digits = new int[digits.length + 1];
digits[0] = 1;
return digits;   

    }
}