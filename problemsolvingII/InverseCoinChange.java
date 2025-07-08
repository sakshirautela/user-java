import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InverseCoinChange {
    public List<Integer> findCoins(int[] numWays) {
        List<Integer> li = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < numWays.length; i++) {
            if(numWays[i]==0){
                continue;
            }
            if (li.size() == 0) {
                li.add(i + 1);
            } else {
                int ways = getWays(i + 1, 0, 0, li, 0);
                if(ways==numWays[i]-1){
                    if(!hs.contains(i+1)){
                        li.add(i+1);
                        hs.add(i+1);
                    }
                }
            }
        }
        return li;
    }

    private int getWays(int price, int curr, int idx, List<Integer> li, int w) {
        if (idx == li.size()) {
            if (price == curr) {
                return 1;
            } else {
                return 0;
            }
        }
        if (price == curr) {
            return 1;
        }
        if (price > curr) {
            return 0;
        }
        return getWays(price, curr + li.get(idx), idx, li, w + 1)
                + getWays(price, curr + li.get(idx), idx + 1, li, w + 1);
    }
}