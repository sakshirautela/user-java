import java.util.*;

public class Twitter {
    HashMap<Integer, ArrayList<int[]>> id;
    HashMap<Integer, HashSet<Integer>> followers;
    static int t = 0;

    public Twitter() {
        id = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        id.putIfAbsent(userId, new ArrayList<>());
        id.get(userId).add(new int[]{t++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<Integer> li = new ArrayList<>();
        HashSet<Integer> hs = followers.getOrDefault(userId, new HashSet<>());
        for (int f : hs) {
            pq.addAll(id.getOrDefault(f,new ArrayList<>()));
        }
        pq.addAll(id.getOrDefault(userId, new ArrayList<>()));
        int s = 10;
        while (!pq.isEmpty() && s > 0) {
            li.add(pq.remove()[1]);
            s--;
        }
        return li;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */