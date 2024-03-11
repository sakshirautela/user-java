import java.util.*;

class NumFactoredBinaryTrees {
    static int mod= 1000000007;
    public static int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        // create a set to store all the element
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr)
            set.add(i);
        // create a hashmap to store all the possible ways to perticular
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i :arr) hm.put(i,1);

        for (int i :arr){
            for (int j :arr){
                if(i==j) break;
                if(i%j==0 && set.contains(i/j)){
                    long ways=hm.get(i/j)*hm.get(j);
                    hm.put(i,(int) ((hm.get(i)+((j==i/j)?ways:ways*2))%mod));
                }
            }
        }
        int res=0;
        for(int i:hm.values()){
            res=(res+i)%mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[] { 2, 4}));//,5,10 }));
    }
}