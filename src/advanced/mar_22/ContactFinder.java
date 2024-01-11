package advanced.mar_22;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactFinder {
  static final int ALPHABET_SIZE = 26;
  static TrieNode root;
  static class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    int ct;
    TrieNode() {
      ct = 0;
      for (int i = 0; i < ALPHABET_SIZE; i++)
        children[i] = null;
    }
  };
  static void insert(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null)
        pCrawl.children[index] = new TrieNode();

      pCrawl = pCrawl.children[index];
      pCrawl.ct++;
    }
  }
  static int search(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null)
        break;
      pCrawl = pCrawl.children[index];
    }
    if (level == key.length())
      return pCrawl.ct;
    return 0;

  }

  static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
    root = new TrieNode();
    int n = A.size();
    ArrayList < Integer > ans = new ArrayList < Integer > ();
    for (int i = 0; i < n; i++) {
      if (A.get(i) == 0)
        insert(B.get(i));
      else
        ans.add(search(B.get(i)));
    }
    return ans;
  }


  public static void main(String[] args) {
//    System.out.println("" + solve(new ArrayList<String>(Arrays.asList("hat", "cat", "rat")),
//        new ArrayList<String>(Arrays.asList("cat", "ball"))));
    System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)),
        new ArrayList<String>(Arrays.asList("hack", "hacker", "hac", "hak"))));
  }

}


/*
public class Solution {
  static final int ALPHABET_SIZE = 26;
  static TrieNode root;
  static class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    int ct;
    TrieNode() {
      ct = 0;
      for (int i = 0; i < ALPHABET_SIZE; i++)
        children[i] = null;
    }
  };
  static void insert(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null)
        pCrawl.children[index] = new TrieNode();

      pCrawl = pCrawl.children[index];
      pCrawl.ct++;
    }
  }
  static int search(String key) {
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (pCrawl.children[index] == null)
        break;
      pCrawl = pCrawl.children[index];
    }
    if (level == key.length())
      return pCrawl.ct;
    return 0;

  }
  public int[] solve(int[] A, String[] B) {
    root = new TrieNode();
    int q = A.length;
    ArrayList < Integer > v = new ArrayList < Integer > ();
    for (int i = 0; i < q; i++) {
      if (A[i] == 0)
        insert(B[i]);
      else
        v.add(search(B[i]));
    }
    int[] res = new int[v.size()];
    int index = 0;
    for (int a: v)
      res[index++] = a;
    return res;
  }
}*/