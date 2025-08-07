import java.util.*;

public class RemoveSubFoldersfromtheFilesystem {
    public static void main(String[] args) {
        System.out.println();
    }
        static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            TrieNode() {
                this.children = new TrieNode[27];
                this.isEndOfWord = false;
            }
        }

        TrieNode root;

        private int getIndex(char ch) {
            if (ch == '/') {
                return 26;
            }

            return ch - 'a';
        }

        private void insert(String s) {
            TrieNode curr = root;

            for (int i = 0; i < s.length(); i++) {
                int idx = getIndex(s.charAt(i));

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }

            curr.children[26] = new TrieNode();
            curr = curr.children[26];
            curr.isEndOfWord = true;
        }

        private boolean search(String s) {
            TrieNode curr = root;

            for (int i = 0; i < s.length(); i++) {
                if (curr.isEndOfWord) {
                    return true;
                }

                int idx = getIndex(s.charAt(i));

                if (curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
            return curr.isEndOfWord;
        }

        public List<String> removeSubfoldersFast(String[] folder) {
            root = new TrieNode();
            Arrays.sort(folder, (a, b) -> a.length() - b.length());
            List<String> ans = new ArrayList<>();

            for (String f : folder) {
                if (!search(f)) {
                    insert(f);
                    ans.add(f);
                }
            }
            return ans;
        }
    public List<String> removeSubfolders2(String[] folder) {
        Arrays.sort(folder);
        List<String> li = new ArrayList<>();
        li.add(folder[0]);
        String compare=folder[0]+'/';
        int n=folder.length;
        for(int i=1;i<n;i++){
            String curr=folder[i];
            if(!curr.startsWith(compare)){
                compare=curr+'/';
                li.add(curr);
            }
        }
        return li;
    }

    public List<String> removeSubfolders(String[] folder) {

        List<String> li = new ArrayList<>();
        HashSet<String> hs = new HashSet<>(Arrays.asList(folder));
        int n = folder.length;
        for (String curr : folder) {
            String pre = curr;
            boolean isSub = false;
            while (!pre.isEmpty()) {
                int idx = curr.lastIndexOf('/');
                if (idx == -1) {
                    break;
                }
                pre = curr.substring(0, idx);
                if (hs.contains(pre)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                li.add(curr);
            }
        }
        return li;
    }

}
