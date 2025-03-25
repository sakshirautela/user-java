import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class FindAllPossibleRecipesfromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> li = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (String s : supplies) {
            hs.add(s);
        }
        Queue<Integer> canCreate = new LinkedList<>();
        int n = recipes.length;
        for (int index = 0; index < n; index++) {
            canCreate.offer(index);
        }
        while (!canCreate.isEmpty()) {
            int i = canCreate.poll();
            boolean contain = true;
            for (String s : ingredients.get(i)) {
                if (!hs.contains(s)) {
                    contain = false;
                    break;
                }
            }
            if (contain) {
                hs.add(recipes[i]);
                li.add(recipes[i]);
            } else {
                canCreate.offer(i);
            }
        }
        return li;
    }
}