package com.akshay.learning.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

https://leetcode.com/problems/word-search-ii/

* Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
* vertically neighboring. The same letter cell may not be used more than once in a word.
*
* Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
* */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0) return Collections.emptyList();
        Trie trieRoot = getTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWordsDFS(board, i, j, trieRoot, res);
            }
        }
        return res;
    }

    private void findWordsDFS(char[][] board, int i, int j, Trie trieRoot, List<String> res) {
        char currChar = board[i][j];
        if(currChar == '$' || trieRoot.getChildren()[currChar - 'a'] == null){
            return;
        }
        Trie child = trieRoot.getChildren()[currChar - 'a'];
        board[i][j] = '$';
        if(child.isEnd()){
            res.add(child.getWord());
        }
        if(i > 0)
            findWordsDFS(board, i-1, j, child, res);
        if(i < board.length-1)
            findWordsDFS(board, i+1, j, child, res);
        if(j > 0)
            findWordsDFS(board, i, j-1, child, res);
        if(j < board[0].length-1)
            findWordsDFS(board, i, j+1, child, res);
        board[i][j] = currChar;
    }

    private Trie getTrie(String[] words) {
        Trie trieRoot = new Trie();
        for (String word :
                words) {
            trieRoot.insert(word);
        }
        return trieRoot;
    }
}
