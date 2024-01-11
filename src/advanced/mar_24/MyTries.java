package advanced.mar_24;

public class MyTries {

  class Node {

    Node[] children = new Node[26];
    boolean eow;


    Node() {
      for (int i = 0; i < 26; i++) {
        children[i] = null;
      }
    }
  }

  Node root = new Node();

  void insert(String word) {// The
    Node curr = root;
    int level = 0;
    int len = word.length();
    int idx = 0;
    for (; level < len; level++) {
      idx = word.charAt(level) - 'a';
      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }
      curr = curr.children[idx];
    }
    curr.eow = true;
  }

  boolean search(String word) {
    Node curr = root;
    int level = 0;
    int idx = 0;
    int len = word.length();
    for (; level < len; level++) {
      idx = word.charAt(level) - 'a';
      if (curr.children[idx] == null) {
        return false;
      }
      curr = curr.children[idx];
    }
    return curr.eow == true;// false
  }

  public static void main(String[] args) {
    MyTries t = new MyTries();
    String words[] = {"the", "a", "there", "their", "any", "thee"};
    for (int i = 0; i < words.length; i++) {
      t.insert(words[i]);
    }
    System.out.println(" " + t.search("there"));
    System.out.println(" " + t.search("theee"));
  }
}
