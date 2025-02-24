import java.util.Arrays;
import java.util.HashSet;

public class ConstructtheLexicographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {

        int size = 2 * n - 1;
        HashSet<Integer> pp = new HashSet<>();
        int[] ans = new int[size];
        Arrays.fill(ans, -1);

        construct(ans, pp, n, 0);

        return ans;
    }

    public boolean construct(int[] ans, HashSet<Integer> pp, int n, int idx) {

        while (idx < ans.length && ans[idx] != -1)
            idx++;
        if (idx == ans.length)
            return true;

        for (int i = n; i >= 1; i--) {

            int secidx = i == 1 ? idx : idx + i;
            if (!pp.contains(i) && secidx < ans.length && ans[secidx] == -1) {
                pp.add(i);
                ans[idx] = i;
                ans[secidx] = i;

                if (construct(ans, pp, n, idx + 1))
                    return true;

                pp.remove(i);
                ans[idx] = -1;
                ans[secidx] = -1;
            }

        }
        return false;
    }

    public int[] constructDistancedSequence2(int targetNumber) {
        // Initialize the result sequence with size 2*n - 1 filled with 0s
        int[] resultSequence = new int[targetNumber * 2 - 1];

        // Keep track of which numbers are already placed in the sequence
        boolean[] isNumberUsed = new boolean[targetNumber + 1];

        // Start recursive backtracking to construct the sequence
        findLexicographicallyLargestSequence(
                0,
                resultSequence,
                isNumberUsed,
                targetNumber);

        return resultSequence;
    }

    // Recursive function to generate the desired sequence
    private boolean findLexicographicallyLargestSequence(
            int currentIndex,
            int[] resultSequence,
            boolean[] isNumberUsed,
            int targetNumber) {
        // If we have filled all positions, return true indicating success
        if (currentIndex == resultSequence.length) {
            return true;
        }

        // If the current position is already filled, move to the next index
        if (resultSequence[currentIndex] != 0) {
            return findLexicographicallyLargestSequence(
                    currentIndex + 1,
                    resultSequence,
                    isNumberUsed,
                    targetNumber);
        }

        // Attempt to place numbers from targetNumber to 1 for a
        // lexicographically largest result
        for (int numberToPlace = targetNumber; numberToPlace >= 1; numberToPlace--) {
            if (isNumberUsed[numberToPlace])
                continue;

            isNumberUsed[numberToPlace] = true;
            resultSequence[currentIndex] = numberToPlace;

            // If placing number 1, move to the next index directly
            if (numberToPlace == 1) {
                if (findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber)) {
                    return true;
                }
            }
            // Place larger numbers at two positions if valid
            else if (currentIndex + numberToPlace < resultSequence.length &&
                    resultSequence[currentIndex + numberToPlace] == 0) {
                resultSequence[currentIndex + numberToPlace] = numberToPlace;

                if (findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber)) {
                    return true;
                }

                // Undo the placement for backtracking
                resultSequence[currentIndex + numberToPlace] = 0;
            }

            // Undo current placement and mark the number as unused
            resultSequence[currentIndex] = 0;
            isNumberUsed[numberToPlace] = false;
        }

        return false;
    }
}