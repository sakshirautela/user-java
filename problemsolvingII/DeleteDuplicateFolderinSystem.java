import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DeleteDuplicateFolderinSystem {
    public static void main(String[] args) {
        System.out.println(deleteDuplicateFolder(new ArrayList<>()));
    }

    static class Trie {
        String folder;
        HashMap<String, Trie> identical = new HashMap<>();
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {

        Trie root = new Trie();
        int n = paths.size();
        for (int i = 0; i < n; i++) {
            Trie curr = root;
            for (String folder : paths.get(i)) {
                if (!curr.identical.containsKey(folder)) {
                    curr.identical.put(folder, new Trie());
                }
                curr = curr.identical.get(folder);
            }
        }

        HashMap<String, Integer> freq = new HashMap<>();
        construct(root, freq);
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        operate(root, freq, path, ans);
        return ans;
    }

    private static void construct(Trie node, HashMap<String, Integer> freq) {
        if (node.identical.isEmpty()) return;
        List<String> v = new ArrayList<>();
        for (HashMap.Entry<String, Trie> entry : node.identical.entrySet()) {
            construct(entry.getValue(), freq);
            v.add(entry.getKey() + "(" + entry.getValue().folder + ")");
        }

        Collections.sort(v);
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        node.folder = sb.toString();
        freq.put(node.folder, freq.getOrDefault(node.folder, 0) + 1);
    }

    private static void operate(Trie node, HashMap<String, Integer> freq, List<String> path, List<List<String>> ans) {
        if (freq.getOrDefault(node.folder, 0) > 1)
            return; // if the serialization representation appears more than once, it needs to be deleted

        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }

        for (HashMap.Entry<String, Trie> entry : node.identical.entrySet()) {
            path.add(entry.getKey());
            operate(entry.getValue(), freq, path, ans);
            path.remove(path.size() - 1);
        }
    }
}