package com.akshay.learning.Trie;

import java.util.Set;

public class Trie {
    private boolean isEnd;
    private Trie[] children;
    private final int TOTAL_CHILDREN = 26;

    // optional part
//    private char ch;
    private String word;

    public Trie() {
        children = new Trie[TOTAL_CHILDREN];
    }

    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Trie[] getChildren() {
        return children;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void insert(String word) {
        Trie currNode = this;
        for (char currChar : word.toCharArray()) {
            if(currNode.children[currChar -'a'] != null){
                currNode = currNode.children[currChar -'a'];
            } else {
                currNode = currNode.children[currChar-'a'] = new Trie();
            }
        }
        currNode.setEnd(true);
        currNode.setWord(word);
    }

    public boolean search(String word) {
        Trie currNode = this;
        for (char currChar : word.toCharArray()) {
            if(currNode.children[currChar -'a'] != null){
                currNode = currNode.children[currChar -'a'];
            } else {
                return false;
            }
        }
        return currNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie currNode = this;
        for (char currChar : prefix.toCharArray()) {
            if(currNode.children[currChar -'a'] != null){
                currNode = currNode.children[currChar -'a'];
            } else {
                return false;
            }
        }
        return true;
    }

}
