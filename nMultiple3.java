import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class nMultiple3 {
    public static void main(String args[]) {
        int[] digits = {1,1,1,2 };

        String result = "";
        List<Integer> arr = new ArrayList<>();
        // int k=0;
        int pos = digits.length - 1;
        // int pos=4;
        int sum = 0;
        int temp = -1;
        String str = "";

        for (int i = 0; i < digits.length; i++) {
            arr.add(digits[i]);

            sum = sum + digits[i];

        }

        if (sum == 0) {
            System.out.println("0");
        }
        if (sum % 3 == 0) {
            Collections.sort(arr);
            for (int i = 0; i < arr.size(); i++) {
                str = String.valueOf(arr.get(i)) + str;
            }
            System.out.println(str);

        }
        int k=0;
        while (pos >= 0) {
            for (int i = digits.length - 1; i >= 0; i--) {
                sum = 0;
                arr.clear();
                str = "";
                for (int j = digits.length - 1; j >= 0; j--) {
                    if (j != i && j != pos) {
                        arr.add(digits[j]);
                        sum = sum + digits[j];

                        // k++;

                    }

                }
                if (sum % 3 == 0 && temp <= sum && k<arr.size() ) {
                    k=arr.size();
                    temp = sum;
                    Collections.sort(arr);
                    result="";


                    
                    for (int x = 0; x < arr.size(); x++) {
                        result = String.valueOf(arr.get(x)) + result;
                    }


                }


            }
            
            
            pos--;
        }
        System.out.println(result);
    }

}
