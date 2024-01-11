package advanced.mar_24;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

  static final int ALPHABET_SIZE = 26;
  static TrieNode root;

  static class TrieNode {

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    TrieNode() {
      isEndOfWord = false;
      for (int i = 0; i < ALPHABET_SIZE; i++) {
        children[i] = null;
      }
    }
  }


  public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
    ArrayList<Integer> ans = new ArrayList<>();
    root = new TrieNode();
    for (String temp : A) {
      insert(temp);
    }
    for (int i = 0; i < B.size(); i++) {
      if (search(B.get(i)) == true) {
        ans.add(1);
      } else {
        ans.add(0);
      }
    }
    return ans;
  }

  /* public int[] solve(String[] A, String[] B) {
     root = new TrieNode();
     for (String temp: A)
       insert(temp);
     int[] ans = new int[B.length];
     for (int i = 0; i < B.length; i++) {
       if (search(B[i]) == true)
         ans[i] = 1;
       else ans[i] = 0;
     }
     return ans;
   }*/
  static void insert(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null) {
        pCrawl.children[index] = new TrieNode();
      }
      pCrawl = pCrawl.children[index];
    }
    pCrawl.isEndOfWord = true;
  }

  static boolean search(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null) {
        return false;
      }
      pCrawl = pCrawl.children[index];
    }
    return (pCrawl != null && pCrawl.isEndOfWord);
  }

  public static void main(String[] args) {
    //  int[] input = { 25, 10, 2, 8, 5, 3 };

    MaximumXOR.trie t = new MaximumXOR.trie();
    System.out.print(t.solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
  }
}
