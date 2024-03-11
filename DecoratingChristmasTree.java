import java.util.Scanner;

public class DecoratingChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (canDecorateTree(n, x, y)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    static boolean canDecorateTree(int n, int x, int y) {
        return x >= n && (x + y) >= 3 * n;
    }
}
