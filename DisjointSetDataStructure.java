public class DisjointSetDataStructure {
    public static int n = 8;
    public static int[] par = new int[n];
    public static int[] rank = new int[n]; // fill all with 0 (by default)

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
    }

    public static int pathCompressed(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = pathCompressed(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3)); // Prints the representative of element 3
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3)); // Prints the representative of element 3
        union(1, 5);
    }
}
