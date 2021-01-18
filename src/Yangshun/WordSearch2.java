package Yangshun;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

  /*
  Given an m x n board of characters and a list of strings words, return all words on the board.

  Each word must be constructed from letters of sequentially adjacent cells,
  where adjacent cells are horizontally or vertically neighboring.
  The same letter cell may not be used more than once in a word.
   */

  // use a trie data structure
  // first build to trie then using the word property we can immediately add
  public List<String> findWords(char[][] board, String[] words) {

    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, res);
      }
    }

    return res;
  }

  public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.children[c - 'a'] == null) {
      return;
    }
    p = p.children[c - 'a'];
    if (p.word != null) { // gets rid of duplication
      res.add(p.word);
      p.word = null;
    }

    board[i][j] = '#';  // marks as seen

    if (i > 0) dfs(board, i - 1, j, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res);
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (j < board[i].length - 1) dfs(board, i, j + 1, p, res);

    board[i][j] = c;
  }

  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String s : words) {
      TrieNode p = root;
      for (char c : s.toCharArray()) {
        int i = c - 'a';
        if (p.children[i] == null) {
          p.children[i] = new TrieNode();
        }
        p = p.children[i];
      }
      p.word = s;
    }
    return root;
  }

  static class TrieNode {

    public TrieNode[] children = new TrieNode[26];
    public String word;
  }

}

