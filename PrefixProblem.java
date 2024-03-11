public class PrefixProblem {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;
        int freq ;

        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
             freq = 1;

        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            } else {
                curr.child[idx].freq++;
            }
            curr = curr.child[idx];

        }
        curr.eow = true;
    }

    public static void prefix(Node root ,String res){ 
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                prefix(root.child[ i ],res+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        String[] word = { "zebra", "dog", "dove", "duck" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        root.freq=-1;
        prefix(root,"");
    }
}
