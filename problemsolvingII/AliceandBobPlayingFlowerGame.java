public class AliceandBobPlayingFlowerGame {
    public static void main(String[] args) {
        System.out.println(flowerGame(3, 2));
    }

    public static long flowerGame(int n, int m) {
        return ((long) m *n)/2;
    }
}
