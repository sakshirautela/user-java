
public class GasStationGFG {
    public static void main(String[] args) {
        System.out.println(startStation(new int[] {}, new int[] {}));
    }

    public static int startStation(int[] gas, int[] cost) {
        // Your code here
        int total = 0;
        int idx = 0;
        int g = 0;
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            g += gas[i] - cost[i];
            if (g < 0) {
                idx = i + 1;
                g = 0;
            }
            total += gas[i] - cost[i];
        }
        return (total >= 0) ? idx : -1;
    }
}
