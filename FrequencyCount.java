import java.util.Arrays;
import java.util.Collections;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        int elementToCount = 3; // Change this to the element you want to count

        int count = Collections.frequency(Arrays.asList(nums), elementToCount);

        System.out.println("The frequency of " + elementToCount + " is: " + count);
    }
}
