package advanced.mar_13;



import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// A Binary Tree Node
  class TreeNode {
      int val;
      TreeNode left;
    TreeNode right;
     TreeNode(int x) {
       val = x;
       left=null;
       right=null;
     }
  }
class Node {
  int data;
  Node left, right;
  public Node(int d)
  {
    data = d;
    left = right = null;
  }
}

class RightViewBinaryTree {
  Node root;

  void rightView(Node root)
  {
    if (root == null) {
      return;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {

      // get number of nodes for each level
      int n = q.size();

      // traverse all the nodes of the current level
      for (int i = 1; i <=n; i++) {
        Node curr = q.poll();
      //  q.remove();

        // print the last node of each level
        if (i == 1) {
          System.out.print(curr.data);
          System.out.print(" ");
        }

        // if left child is not null add it into
        // the
        // queue
        if (curr.left != null) {
          q.add(curr.left);
        }

        // if right child is not null add it into
        // the
        // queue
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
  }

  private static void printLeftView(Node root)
  {
    if (root == null)
      return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      // number of nodes at current level
      int n = queue.size();

      // Traverse all nodes of current level
      for (int i = 1; i <= n; i++) {
        Node temp = queue.poll();

        // Print the left most element at
        // the level
        if (i == 1)
          System.out.print(temp.data + " ");

        // Add left node to queue
        if (temp.left != null)
          queue.add(temp.left);

        // Add right node to queue
        if (temp.right != null)
          queue.add(temp.right);
      }
    }
  }
  private  ArrayList<Integer> solve(Node A) {
    ArrayList<Integer> ans= new ArrayList<>();
    if (root == null) {
      return ans;
    }

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int n = q.size();

      for (int i = 0; i < n; i++) {
        Node curr = q.peek();
        q.remove();

        if (i == n - 1) {
          System.out.print(curr.data);
          ans.add(curr.data);
          System.out.print(" ");
        }
        if (curr.left != null) {
          q.add(curr.left);
        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
    return ans;
  }
  // Driver code
  public static void main(String[] args)
  {

    RightViewBinaryTree tree = new RightViewBinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.root.right.left.right = new Node(8);

    tree.rightView(tree.root);
    System.out.println("");
    tree.printLeftView(tree.root);

    //System.out.println(""+tree.solve(tree.root));
  }
}

