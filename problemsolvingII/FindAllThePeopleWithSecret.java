import java.util.*;

public class FindAllThePeopleWithSecret {
    static void main() {
        System.out.println(findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3));
    }

    public static List<Integer> findAllPeopleUnionFInd(int n, int[][] meetings, int firstPerson) {
        List<Integer> li = new ArrayList<>();
        boolean[] knows = new boolean[n];
        TreeMap<Integer, ArrayList<int[]>> time = new TreeMap<>();
        for (int[] meeting : meetings) {
            time.putIfAbsent(meeting[2], new ArrayList<>());
            time.get(meeting[2]).add(new int[]{meeting[0], meeting[1]});
        }
        UnionFind uf=new UnionFind(n);
        uf.union(0,firstPerson);
        for (int t : time.keySet()) {
            for (int[] meet : time.get(t)) {
                uf.union(meet[0],meet[1]);
            }
            for (int[] meet : time.get(t)) {
                if(!uf.connected(meet[0],0)){
                    uf.reset(meet[0]);
                    uf.reset(meet[1]);
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            if(uf.connected(0,i)){
                li.add(i);
            }
        }
        return li;
    }

    static class UnionFind {
        private  void union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x != y) {
                if (rank[x] > rank[y]) {
                    par[y] = x;
                } else if (rank[x] < rank[y]) {
                    par[x] = y;
                } else {
                    par[y] = x;
                    rank[x]++;
                }
            }
        }

        private int[] par;
        private int[] rank;

        private  UnionFind(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        void reset(int x) {
            rank[x] = 0;
            par[x] = x;
        }

        private  int find(int n) {
            if (par[n] != n) {
                par[n] = find(par[n]);
            }
            return par[n];
        }
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> (a[2] - b[2]));
        boolean[] knows = new boolean[n];
        List<Integer> li = new ArrayList<>();
        knows[0] = true;
        knows[firstPerson] = true;
        int last = 0;
        li.add(0);
        li.add(firstPerson);
        for (int[] meeting : meetings) {
            if (knows[meeting[0]] && knows[meeting[1]]) {
            } else if (knows[meeting[0]]) {
                li.add(meeting[1]);
                knows[meeting[1]] = true;
            } else if (knows[meeting[1]]) {
                li.add(meeting[0]);
                knows[meeting[0]] = true;

            }
        }
        return li;
    }
    public List<Integer> findAllPeopleFast(int n, int[][] meetings, int firstPerson) {
        return new AbstractList<Integer>() {
            List<Integer> results;
            int[] parent = new int[n + 1];

            void init() {
                if (results != null) return;
                results = new ArrayList<>();
                parent = new int[n + 1];
                for (int i = 0; i <= n; i++) {
                    parent[i] = i;
                }
                parent[firstPerson] = 0;

                int maxTime = 0;
                for (int[] meet : meetings) {
                    maxTime = Math.max(maxTime, meet[2]);
                }

                List<int[]>[] timeArray = new List[maxTime + 1];
                for (int[] meet : meetings) {
                    if (timeArray[meet[2]] == null) {
                        timeArray[meet[2]] = new ArrayList<>();
                    }
                    timeArray[meet[2]].add(new int[]{meet[0], meet[1]});
                }

                for (int i = 1; i < timeArray.length; i++) {
                    if (timeArray[i] != null) {
                        for (int j = 0; j < timeArray[i].size(); j++) {
                            int u = timeArray[i].get(j)[0];
                            int v = timeArray[i].get(j)[1];
                            union(u, v, parent);
                        }
                        for (int j = 0; j < timeArray[i].size(); j++) {
                            int u = timeArray[i].get(j)[0];
                            int v = timeArray[i].get(j)[1];
                            if (find(u, parent) != 0) {
                                parent[u] = u;
                            }
                            if (find(v, parent) != 0) {
                                parent[v] = v;
                            }
                        }
                    }
                }
                for (int i = 0; i < parent.length; i++) {
                    if (parent[i] == 0) {
                        results.add(i);
                    }
                }
            }

            @Override
            public Integer get(int index) {
                init();
                return results.get(index);
            }

            @Override
            public int size() {
                init();
                return results.size();
            }
            private void union(int u, int v, int[] parent) {
                int uRoot = find(u, parent);
                int vRoot = find(v, parent);
                if (uRoot < vRoot) {
                    parent[vRoot] = uRoot;
                } else {
                    parent[uRoot] = vRoot;
                }
            }

            private int find(int x, int[] parent) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x], parent);
                }

                return parent[x];
            }
        };
    }
}