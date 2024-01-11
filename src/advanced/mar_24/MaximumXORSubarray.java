package advanced.mar_24;

import java.util.ArrayList;
import java.util.Arrays;

//
class MaximumXORSubarray {

  static final int INT_SIZE = 32;

   class TrieNode {

    int value;
    TrieNode[] arr = new TrieNode[2];

    public TrieNode() {
      value = 0;
      arr[0] = null;
      arr[1] = null;
    }
  }
  class Trie {

    TrieNode root = new TrieNode();

    void insert(int pre_xor) {
      TrieNode temp = root;
      for (int i = INT_SIZE - 1; i >= 0; i--) {
        int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
        if (temp.arr[val] == null)
          temp.arr[val] = new TrieNode();

        temp = temp.arr[val];
      }
      temp.value = pre_xor;
    }

    int query(int pre_xor) {
      TrieNode temp = root;
      for (int i = INT_SIZE - 1; i >= 0; i--) {
        int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
        if (temp.arr[1 - val] != null)
          temp = temp.arr[1 - val];
        else if (temp.arr[val] != null)
          temp = temp.arr[val];
      }
      return pre_xor ^ (temp.value);
    }

  }
  ArrayList<Integer> maxSubarrayXOR(ArrayList<Integer> A) {
   // TrieNode temp = rot;
    Trie t = new Trie();
    ArrayList<Integer> ans = new ArrayList<>();
    int n = A.size();
    if (n == 1) {
      ans.add(1);
      ans.add(1);
      return ans;
    }
   // root = new TrieNode();
    t.insert(0);
    int result = Integer.MIN_VALUE;
    int pre_xor = 0;
    System.out.println(" Size of word "+n);
    for (int i = 0; i < n; i++) {
      ans.clear();
      ans.add(i);
      ans.add(A.get(i));
      System.out.println(pre_xor+" pre_xor "+A.get(i));
      pre_xor = pre_xor ^ A.get(i);

      t.insert(pre_xor);
      result = Math.max(result, t.query(pre_xor));
      System.out.println(result);
    }
    return ans;
  }
  public static void main(String args[]) {
    MaximumXORSubarray t = new MaximumXORSubarray();
    //int arr[] = {8, 1, 2, 12};
    //int arr[] = {1, 4, 3};
    int arr[] = {33, 29, 18};
    int n = arr.length;
    System.out.println("Max subarray XOR is " +
        t.maxSubarrayXOR(new ArrayList<>(Arrays.asList(1, 4, 3))));
  }
}
