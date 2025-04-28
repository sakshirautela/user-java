package com.learn.java.problemsolving;

public class ImplementTriePrefixTree {
    // Trie Node definition
    static class Node {
        Node[] children;
        boolean isEndOfWord;

        public Node() {
            children = new Node[26];  // Only lowercase English letters, 26 children
            isEndOfWord = false;
        }
    }

    private Node root;  // Root node of the Trie

    // Constructor to initialize the root of the Trie
    public ImplementTriePrefixTree() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node current = root;  // Start at the root node
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';  // Find index for the character (0 for 'a', 1 for 'b', ...)
            if (current.children[idx] == null) {  // If there's no child at that index, create a new node
                current.children[idx] = new Node();
            }
            current = current.children[idx];  // Move to the next node
        }
        current.isEndOfWord = true;  // Mark the end of the word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';  // Find index for the character
            if (current.children[idx] == null) {  // If a child is missing, the word isn't in the Trie
                return false;
            }
            current = current.children[idx];
        }
        return current.isEndOfWord;  // Check if the current node marks the end of the word
    }

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';  // Find index for the character
            if (current.children[idx] == null) {  // If a child is missing, no words with the prefix exist
                return false;
            }
            current = current.children[idx];
        }
        return true;  // If all characters of the prefix exist, return true
    }

    // Main method for testing the Trie
    public static void main(String[] args) {
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // Returns true
        System.out.println(trie.search("app"));     // Returns false
        System.out.println(trie.startsWith("app")); // Returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // Returns true
    }
}
