public class ImplementTriePrefixTree {
    static class Node{
        Node child[];
        boolean eow=false;
        public Node(){
            child=new Node[26];
        }
    }
    Node trie;
    public ImplementTriePrefixTree() {
        trie=new Node();
    }
    
    public void insert(String word) {
        Node curr=trie;
        int n=word.length();
        for (int i = 0; i < n; i++) {
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        Node curr=trie;
        int n=word.length();
        for (int i = 0; i < n; i++) {
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Node curr=trie;
        int n=prefix.length();
        for (int i = 0; i < n; i++) {
            int idx=prefix.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return true;
    }
}
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (idx == word.length()-1) nodes[i].isEnd = true;
            nodes[i].insert(word, idx+1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == word.length() - 1 && node.isEnd) return true;

            return node.search(word, idx+1);

        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == prefix.length() - 1) return true;

            return node.startsWith(prefix, idx+1);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */