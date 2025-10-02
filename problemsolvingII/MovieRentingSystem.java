import java.util.*;

public class MovieRentingSystem {

    private static class Entry {
        int price, shop, movie;

        Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return price == e.price && shop == e.shop && movie == e.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    private Map<Integer, TreeSet<Entry>> availableMovies;
    private TreeSet<Entry> rentedMovies;
    private Map<String, Entry> entryMap;

    public MovieRentingSystem(int n, int[][] entries) {
        availableMovies = new HashMap<>();
        rentedMovies = new TreeSet<>(
                (a, b) -> a.price != b.price ? Integer.compare(a.price, b.price) :
                        (a.shop != b.shop ? Integer.compare(a.shop, b.shop) :
                                Integer.compare(a.movie, b.movie))
        );
        entryMap = new HashMap<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            String key = shop + "#" + movie;

            Entry e = new Entry(price, shop, movie);
            entryMap.put(key, e);

            availableMovies.putIfAbsent(movie, new TreeSet<>(
                    (a, b) -> a.price != b.price ? Integer.compare(a.price, b.price) :
                            Integer.compare(a.shop, b.shop)
            ));
            availableMovies.get(movie).add(e);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (availableMovies.containsKey(movie)) {
            int count = 0;
            for (Entry e : availableMovies.get(movie)) {
                if (count == 5) break;
                result.add(e.shop);
                count++;
            }
        }
        return result;
    }

    public void rent(int shop, int movie) {
        String key = shop + "#" + movie;
        Entry e = entryMap.get(key);
        availableMovies.get(movie).remove(e);
        rentedMovies.add(e);
    }

    public void drop(int shop, int movie) {
        String key = shop + "#" + movie;
        Entry e = entryMap.get(key);
        rentedMovies.remove(e);
        availableMovies.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (Entry e : rentedMovies) {
            if (count == 5) break;
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return result;
    }
}
/*
class MovieRentingSystem {
    private static class Node {
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Order: price ↑, shop ↑, movie ↑  (strict: never returns 0 for distinct nodes)
    private static final Comparator<Node> CMP =
        (a, b) -> {
            int c = Integer.compare(a.price, b.price);
            if (c != 0) return c;
            c = Integer.compare(a.shop, b.shop);
            if (c != 0) return c;
            return Integer.compare(a.movie, b.movie);
        };

    // Available copies grouped by movie
    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
    // All currently rented copies
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
    // Quick lookup from (shop, movie) -> Node
    private final Map<Long, Node> byPair = new HashMap<>();

    private static long key(int shop, int movie) {
        return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node);
            availableByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(CMP))
                .add(node);
        }
    }

    // Return up to 5 shops with this movie, cheapest then shop asc.
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set == null || set.isEmpty()) return ans;
        Iterator<Node> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            ans.add(it.next().shop);
        }
        return ans;
    }

    // Move (shop,movie) from available -> rented
    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set != null) set.remove(node);
        rentedSet.add(node);
    }

    // Move (shop,movie) from rented -> available
    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive
        rentedSet.remove(node);
        availableByMovie
            .computeIfAbsent(movie, x -> new TreeSet<>(CMP))
            .add(node);
    }

    // Return up to 5 rented copies [shop, movie], cheapest then shop asc, then movie asc.
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
