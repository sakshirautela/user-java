import java.util.Arrays;
import java.util.Scanner;
 
public class KefaAndCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        long d = scanner.nextLong();
 
        Friend[] friends = new Friend[n];
        for (int i = 0; i < n; i++) {
            long money = scanner.nextLong();
            long friendship = scanner.nextLong();
            friends[i] = new Friend(money, friendship);
        }
 
        Arrays.sort(friends);
 
        long maxFriendship = 0;
        long currentFriendship = 0;
        int left = 0;
 
        for (int right = 0; right < n; right++) {
            while (friends[right].money - friends[left].money >= d) {
                currentFriendship -= friends[left].friendship;
                left++;
            }
 
            currentFriendship += friends[right].friendship;
            maxFriendship = Math.max(maxFriendship, currentFriendship);
        }
 
        System.out.println(maxFriendship);
 
        scanner.close();
    }
 
    static class Friend implements Comparable<Friend> {
        long money;
        long friendship;
 
        Friend(long money, long friendship) {
            this.money = money;
            this.friendship = friendship;
        }
 
        @Override
        public int compareTo(Friend other) {
            return Long.compare(this.money, other.money);
        }
    }
}