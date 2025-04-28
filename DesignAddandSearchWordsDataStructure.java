package com.learn.java.problemsolving;

public class DesignAddandSearchWordsDataStructure {
    public class Node {
        boolean eow;
        Node[] child;

        public Node() {
            eow = false;
            child = new Node[26];
        }
    }

    Node root;

    public DesignAddandSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
        node.eow = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root);
    }

    private boolean searchHelper(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.child[j] != null && searchHelper(word.substring(i + 1), node.child[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                if (node.child[idx] == null) {
                    return false;
                }
                node = node.child[idx];
            }
        }
        return node.eow;
    }
    class WordDictionary {
        Object[] trie;
    
        public WordDictionary() {
            trie = new Object[27];
        }
    
        public void addWord(String word) {
            Object[] cur = trie;
            for (char c : word.toCharArray()) {
                if (cur[c - 'a'] == null) {
                    cur[c - 'a'] = new Object[27];
                }
                cur = (Object[]) cur[c - 'a'];
            }
            cur[26] = new Object[1];
        }
    
        static boolean isWord(int ind, char[] word, Object[] subTrie) {
            if (word[ind] == '.') {
                boolean resp = false;
                for (int i = 0; i < 26; i++) {
                    if (subTrie[i] != null) {
                        if (ind == word.length - 1) {
                            if (((Object[]) subTrie[i])[26] != null)
                                resp = true;
                        } else {
                            resp = isWord(ind + 1, word, (Object[]) subTrie[i]);
    
                        }
                        if (resp)
                            return true;
                    }
                }
                return false;
            } else {
                if (subTrie[word[ind] - 'a'] != null) {
                    if (ind == word.length - 1) {
                        Object[] next = (Object[]) subTrie[word[ind] - 'a'];
                        return next[26] != null;
                    } else
                        return isWord(ind + 1, word, (Object[]) subTrie[word[ind] - 'a']);
                }
                return false;
            }
        }
    
        public boolean search(String word) {
            return isWord(0, word.toCharArray(), trie);
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
