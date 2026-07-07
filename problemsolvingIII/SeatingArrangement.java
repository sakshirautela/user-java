package problemsolvingIII;

public class SeatingArrangement {
    static void main() {
        System.out.println(canSeatAllPeople(4, new int[]{1, 0, 0, 0, 0, 0}));
    }

    public static boolean canSeatAllPeopleMore(int k, int[] seats) {
        int n = seats.length;
        for (int i = 1; i < n; i++) {
            if (seats[i] == 1 && seats[i - 1] == 1) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
                boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
                if (leftEmpty && rightEmpty) {
                    seats[i] = 1;
                    k--;
                    if (k == 0)
                        return true;
                }
            }
        }
        return k<=0;
    }

    public static boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int n = seats.length;
        boolean[] seated = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                seated[i] = true;
                if (i > 0 && seats[i - 1] == 1) {
                    return false;
                } else if (i > 0) {
                    seated[i - 1] = true;
                }
                if (i < n - 1 && seats[i + 1] == 1) {
                    return false;
                } else if (i < n - 1) {
                    seated[i + 1] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!seated[i]) {
                k--;
                seated[i] = true;
                if (i - 1 >= 0) {
                    seated[i - 1] = true;
                }
                if (i + 1 < n) {
                    seated[i + 1] = true;
                }
            }
        }
        if (k <= 0) {
            return true;
        }
        return false;
    }
}
