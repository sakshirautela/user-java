import java.util.HashMap;

public class SumofModes {
    public static void main(String[] args) {
        System.out.println(sumOfModes(new int[]{1, 2, 3, 2, 5, 2, 4, 4}, 3));
    }

    public static int sumOfModes(int[] arr, int k) {
        // code here
        int n = arr.length;
        int sum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        sum += getModeSum(freq,arr[0]);
        for (int i = k; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            freq.put(arr[i - k], freq.getOrDefault(arr[i - k], 0) - 1);
            if (freq.get(arr[i - k]) <= 0) {
                freq.remove(arr[i - k]);
            }
            sum += getModeSum(freq,arr[i-k+1]);
        }
        return sum;
    }

    private static int getModeSum(HashMap<Integer, Integer> freq,int mode) {
        int maxFreq = 0;
        for (int i : freq.keySet()) {
            if(maxFreq<freq.get(i)){
                mode=i;
                maxFreq=freq.get(i);
            }
            if(maxFreq==freq.get(i)){
                mode=Math.min(mode,i);
            }
        }
        return mode;
    }
}