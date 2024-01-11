package advanced.mar_24;


import java.util.ArrayList;
import java.util.Arrays;

class MaximumXOR {

  static class Node {

    public Node one, zero;
  }

  static class trie {

    Node root;

    public trie() {
      root = new Node();
    }

    public void insert(int n) {
      Node temp = root;
      for (int i = 31; i >= 0; i--) {
        int bit = (n >> i) & 1;
        if (bit == 0) {
          if (temp.zero == null) {
            temp.zero = new Node();
          }
          temp = temp.zero;
        } else {
          if (temp.one == null) {
            temp.one = new Node();
          }
          temp = temp.one;
        }
      }
    }

    public int maxXorHelper(int value) {
      Node temp = root;
      int currentAns = 0;
      for (int i = 31; i >= 0; i--) {
        int bit = (value >> i) & 1;
        if (bit == 0) {
          if (temp.one != null) {
            temp = temp.one;
            currentAns += (1 << i);
          } else {
            temp = temp.zero;
          }
        } else {
          if (temp.zero != null) {
            temp = temp.zero;
            currentAns += (1 << i);
          } else {
            temp = temp.one;
          }
        }
      }
      return currentAns;
    }

    public int solve(ArrayList<Integer> A) {
      int maxVal = 0;
      int maxHelper=0;
      insert(A.get(0));
      for (int i = 1; i < A.size(); i++) {
        maxHelper= maxXorHelper(A.get(i));
        System.out.println(maxHelper+"  "+maxVal);
        maxVal = Math.max(maxHelper,
            maxVal);
        insert(A.get(i));
      }
      return maxVal;
    }
  }

  public static void main(String[] args) {
    //  int[] input = { 25, 10, 2, 8, 5, 3 };

    trie t = new trie();
    System.out.print(t.solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
  }
}
