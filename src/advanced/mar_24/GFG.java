package advanced.mar_24;

import java.util.ArrayList;
import java.util.Arrays;

// Java trie based program to find the Number of
// triplets in array having subarray xor equal
class GFG
{

  // maximum number of bits
// in an integer <= 1e9
  static int lg = 31;

  // Structure of a Trie Node
 class TrieNode
  {
    TrieNode children[];
    int sumOfIndexes;
    int numberOfIndexes;
    TrieNode()
    {
      children = new TrieNode[2];
      this.children[0] = null;
      this.children[1] = null;
      this.sumOfIndexes = 0;
      this.numberOfIndexes = 0;
    }
  };

 void insert(TrieNode node,
      int num,
      int index)
  {
    for (int bits = lg; bits >= 0; bits--)
    {
      int curr_bit = (num >> bits) & 1;
      if (node.children[curr_bit]
          == null)
      {
        node.children[curr_bit]
            = new TrieNode();
      }
      node = node.children[curr_bit];
    }
    node.sumOfIndexes += index;
    node.numberOfIndexes++;
  }
   int query(TrieNode node,
      int num,
      int index)
  {

    for (int bits = lg; bits >= 0; bits--)
    {
      int curr_bit = (num >> bits) & 1;
      if (node.children[curr_bit]
          == null)
      {
        return 0;
      }

      node = node.children[curr_bit];
    }
    int sz = node.numberOfIndexes;
    int sum = node.sumOfIndexes;

    int ans = (sz * index) - (sum);

    return ans;
  }

   int solve(ArrayList<Integer> A) {
    int currXOR = 0;
    int numberOfTriplets = 0;
    TrieNode root = new TrieNode();

    for (int i = 0; i < A.size(); i++)
    {
      int x = A.get(i);
      insert(root, currXOR, i);
      currXOR ^= x;

      numberOfTriplets
          += query(root, currXOR, i);
    }
    return numberOfTriplets;
  }
  // Driver Code
  public static void main(String args[])
  {
    // Given array
    int arr[] = { 5, 2, 7 };
    int n = arr.length;
    GFG g = new GFG();
 //   System.out.println(no_of_triplets(arr, n));
    System.out.println(""+g.solve(new ArrayList<Integer>(Arrays.asList(5, 2, 7))));
  }
}

// This code is contributed by Arnab Kundu
