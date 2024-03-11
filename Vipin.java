
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class vipin {

    public static void main(String args[]) {
        int[] digit = { 9, 8, 6, 8, 6 };
        for (int i = 0; i < digit.length; i++) {
            for (int j = i + 1; j < digit.length; j++) {
                if (digit[j] > digit[i]) {
                    // Swap(digit[i],digit[j]);
                    int temp = digit[i];
                    digit[i] = digit[j];
                    digit[j] = temp;
                }
            }
        }

        // Reversing the array

        String result = "";
        List<Integer> arr = new ArrayList<>();
        // int k=0;
        int pos = digit.length - 1;
        // int pos=2;
        int sum = 0;
        int newum = 0;
        int temp = -1;
        int y = -10;
        String str = "";
        // for(int i=digit.length-1;i>=0;i--){
        // digit={9,8,8,6,6};
        arr.clear();

        str = "";
        // int temp = -10;
        for (int i = 0; i < digit.length; i++) {
            y = -10;
            sum = 0;
            for (int j = 0; j < digit.length; j++) {
                sum = digit[i] + digit[j];
                if (sum % 3 == 0 && j == 0) {

                    str = String.valueOf(digit[j]);
                    result = str;

                }

                else {

                    if (sum % 3 == 0 && temp <= sum) {
                        temp = sum;
                        str = String.valueOf(digit[i]) + String.valueOf(digit[j]);
                        result = str;
                    }

                    newum = y == -10 ? digit[j] + sum : y + sum;
                    if ((newum % 3 == 0) && temp <= newum) {
                        str = String.valueOf(digit[i]) + String.valueOf(y) + String.valueOf(digit[j]);
                        temp = newum;
                        result = str;
                    }

                    y = y == -10 ? digit[j] : y + digit[j];
                }

                System.out.println(result);

            }
        }
    }
}
