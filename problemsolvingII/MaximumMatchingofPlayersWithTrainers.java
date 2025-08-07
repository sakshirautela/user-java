import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers {
    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6}));
    }
    // public int minMatchIdx(int s, int e, int[] trainers, int target) {
    //     int ans = trainers.length;
    //     while (s <= e) {
    //         int m = s + (e - s) / 2;
    //         if (trainers[m] >= target) {
    //             ans = m;
    //             e = m - 1;
    //         } else {
    //             s = m + 1;
    //         }
    //     }
    //     return ans;
    // }

    // public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    //     Arrays.sort(players);
    //     Arrays.sort(trainers);
    //     int n = trainers.length;
    //     int s = 0;
    //     int e = n - 1;
    //     int maxMatch = 0;
    //     for (int p : players) {
    //         int idxMatchedWithCurrPlayer = minMatchIdx(s, e, trainers, p);
    //         if (idxMatchedWithCurrPlayer == n) {
    //             break;
    //         }
    //         s = idxMatchedWithCurrPlayer + 1;
    //         maxMatch++;
    //     }
    //     return maxMatch;
    // }

    public int matchPlayersAndTrainersFast(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;

        Thread t1 = new Thread(() -> Arrays.sort(players));
        Thread t2 = new Thread(() -> Arrays.sort(trainers));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (left < m && right < n) {
            if (trainers[right] >= players[left]) {
                count++;
                left++;
            }
            right++;
        }
        return count;
    }
    public static  int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n= players.length;
        int m= trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0, j=0;
        int ans=0;
        while(i<n && j<m){
            if(players[i]<=trainers[j]){
                ans++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return ans;
    }
}