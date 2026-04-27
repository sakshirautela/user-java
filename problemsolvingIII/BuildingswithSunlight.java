package problemsolvingIII;

public class BuildingswithSunlight {
    static void main() {
        System.out.println(visibleBuildings(new int[]{}));
    }

    public static int visibleBuildings(int arr[]) {
        // code here
        int count = 0;
        int max = 0;
        for (int i : arr) {
            if (i >= max) {
                count++;
                max = i;
            }
        }
        return count;
    }
}