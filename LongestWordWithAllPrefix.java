public class LongestWordWithAllPrefix {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new Node();
            } else {
                curr = curr.children[i];
            }
        }
        curr.eow = true;
    }

    static String res = "";

    public static void longestPrefix(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > res.length()) {
                    res = temp.toString();
                }
                longestPrefix(root.children[i], temp);// rescursive
                temp.deleteCharAt(temp.length() - 1);//backtrack
            }
        }
    }

    public static void main(String[] args) {
        String[] word = { "a","banana","app","apple","ap","apply","apple" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        longestPrefix(root, new StringBuilder(""));
        System.out.println(res);

    }
}
