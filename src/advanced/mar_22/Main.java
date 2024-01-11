package advanced.mar_22;

import java.lang.*;
import java.util.*;

public class Main {
  public static void insert(TrieNode root, String s, int wt) {
    TrieNode cur = root;
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(!cur.hm.containsKey(ch)) {
        cur.hm.put(ch, new TrieNode());
      }
      cur = cur.hm.get(ch);

      cur.ar.add(new Pair(s, wt));
      Collections.sort(cur.ar, (a, b) -> {
        return b.wt - a.wt;
      });

      if(cur.ar.size() > 5) {
        cur.ar.remove(cur.ar.size() - 1);
      }
    }
  }
  public static void query(TrieNode root, String s) {
    TrieNode cur = root;
    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(!cur.hm.containsKey(ch)) {
        System.out.println("-1 ");
        return;
      }
      cur = cur.hm.get(ch);
    }

    for(Pair p: cur.ar) {
      System.out.print(p.s + " ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for(int tc = 0; tc < t; tc++) {
      int n, m;
      n = sc.nextInt();
      m = sc.nextInt();

      TrieNode root = new TrieNode();

      String[] str = new String[n];
      for(int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      for(int i = 0; i < n; i++) {
        int wt = sc.nextInt();
        insert(root, str[i], wt);
      }

      for(int i = 0; i < m; i++) {
        String s = sc.next();
        query(root, s);
      }
    }
  }
}
class Pair {
  String s;
  int wt;
  Pair(String s, int wt) {
    this.s = s;
    this.wt = wt;
  }
}

class TrieNode {
  HashMap<Character, TrieNode> hm;
  ArrayList<Pair> ar;
  TrieNode() {
    hm = new HashMap<>();
    ar = new ArrayList<>();
  }
}