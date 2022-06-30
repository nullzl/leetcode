package com.nullzl.offer;


class Node{
    Node[] children = new Node['z' - 'a' + 1];
    boolean isWord = false;
}

class Trie {

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int i = 0;
        Node node = root;
        while(i < word.length() && null != node.children[word.charAt(i) - 'a'])
            node = node.children[word.charAt(i++) - 'a'];
        while(i < word.length()){
            int idx = word.charAt(i++) - 'a';
            node.children[idx] = new Node();
            node = node.children[idx];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int i = 0;
        Node node = root;
        while(i < word.length() && null != node.children[word.charAt(i) - 'a'])
            node = node.children[word.charAt(i++) - 'a'];
        return i == word.length() && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int i = 0;
        Node node = root;
        while(i < prefix.length() && null != node.children[prefix.charAt(i) - 'a'])
            node = node.children[prefix.charAt(i++) - 'a'];
        return i == prefix.length();
    }
}

public class Offer2_62 {
}
