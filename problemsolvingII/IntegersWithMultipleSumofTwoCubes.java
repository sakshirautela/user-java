    static void main() {
        System.out.println(findGoodIntegersTLE(3029));
    }
//        static HashMap<Long, Integer> al;

//        static {
//            al = new HashMap<>();
//            for (int i = 1; i <= 1000; i++) {
//                for (int j = i; j <= 1000; j++) {
//                    long cube = (long)i * i * i + (long)j * j * j;
//                    al.put(cube, al.getOrDefault(cube, 0) + 1);
//                }
//            }
//        }

    public static List<Integer> findGoodIntegersTLE(int n) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Long, Integer> al = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : al.entrySet()) {
            if (entry.getValue() > 1 && entry.getKey() <= n) {
                ans.add(entry.getKey().intValue());
            }
        }
        Collections.sort(ans);
        return ans;
    }
public static List<Integer> findGoodIntegers(int n) {
    List<Integer> set = new ArrayList<>();
    int cube = 1;
    int i = 2;
    set.add(1);
    while (cube <= n) {
        cube = (i * i * i);
        set.add(cube);
        i++;
    }
    List<Integer> list = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();
    HashSet<Integer> hs2 = new HashSet<>();
    HashSet<int[]> res = new HashSet<>();
    for (int a = set.size() - 1; a >= 0; a--) {
        for (int b = a - 1; b >= 0; b--) {
            int sum = set.get(a) + set.get(b);
            if (b < a && sum <= n && hs.contains(sum) && !res.contains(new int[]{a, b})) {
                hs2.add(sum);
            }
            res.add(new int[]{a, b});
            hs.add(sum);

        }
    }
    list.addAll(hs2);
    Collections.sort(list);
    return list;

}