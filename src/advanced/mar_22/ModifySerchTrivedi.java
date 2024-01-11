package advanced.mar_22;

import java.util.ArrayList;
import java.util.Arrays;

public class ModifySerchTrivedi {
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
  static String solve(ArrayList<String> A, ArrayList<String> B) {
    String ans = "";
    root = new TrieNode();
    for (String temp : A) {
      insert(temp);
    }
    for (int i = 0; i < B.size(); i++) {
     // int search(int idx, String s, TrieNode root, int isModified)
      if (search(0,B.get(i),root,0) == 1 && i<A.size()) {
        ans=ans+"1";
      } else {
        ans=ans+"0";
      }
    }
    return ans;

  }

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
  static int search(int idx, String s, TrieNode root, int isModified) {
    if(idx == s.length()) {
      if(root.isEndOfWord == true && isModified == 1) return 1;
      return 0;
    }

    char ch = s.charAt(idx);
    int found = 0;
    if(root.children[ch - 'a'] != null) {
      found = search(idx + 1, s, root.children[ch - 'a'], isModified);
    }

    if(found == 1) return 1;

    if(isModified == 0) {
      for(int i = 0; i < 26; i++) {
        if(root.children[i] != null && i != (ch - 'a')) {
          found = search(idx + 1, s, root.children[i], 1);
        }
        if(found == 1) break;
      }
    }

    return found;
  }
 /* static boolean search(String key) {
    System.out.println(key);
    int level;
    int length = key.length();
    int index;
    TrieNode pCrawl = root;
    int count=0;
    for (level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      System.out.println("index-->"+index);
      if (pCrawl.children[index] == null) {
        System.out.println("pCrawl.children[index]-->"+pCrawl.children[index]);
        count++;
        if(count>1){
          return false;
       }
       // pCrawl = pCrawl.children[index];
      }

      if(count==1) {
        for (int i = 0; i < 26; i++) {
          if (pCrawl.children[i] != null) {
            index=i;
            pCrawl = pCrawl.children[index];
            break;
          }
        }
      }else {
        pCrawl = pCrawl.children[index];
      }
    }
    return (pCrawl != null && pCrawl.isEndOfWord);
  }*/

  public static void main(String[] args) {
    System.out.println("  I am here"+solve(new ArrayList<>(Arrays.asList("data", "circle", "cricket" )),new ArrayList<>(Arrays.asList("date", "circel", "crikket", "data", "circl"))));
  }

}