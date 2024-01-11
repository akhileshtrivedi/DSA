package advanced.mar_13;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterBinaryTree {

  public static int getDiameter(TreeNode root, AtomicInteger diameter)
  {
    if (root == null) {
      return 0;
    }

    int left_height = getDiameter(root.left, diameter);
    int right_height = getDiameter(root.right, diameter);

    int max_diameter = left_height + right_height + 1;

    diameter.set(Math.max(diameter.get(), max_diameter));

    return Math.max(left_height, right_height) + 1;
  }

  /*public static int getDiameter(TreeNode root, AtomicInteger diameter)
  {
    // base case: tree is empty
    if (root == null) {
      return 0;
    }

    // get heights of left and right subtrees
    int left_height = getDiameter(root.left, diameter);
    int right_height = getDiameter(root.right, diameter);

    // calculate diameter "through" the current node
    int max_diameter = left_height + right_height + 1;

    // update maximum diameter (note that diameter "excluding" the current
    // node in the subtree rooted at the current node is already updated
    // since we are doing postorder traversal)
    diameter.set(Math.max(diameter.get(), max_diameter));

    // it is important to return the height of the subtree rooted at the
    // current node
    return Math.max(left_height, right_height) + 1;
  }*/

  public static int getDiameter(Node root)
  {
    AtomicInteger diameter = new AtomicInteger(0);
   // getDiameter(root, diameter);

    return diameter.get();
  }
  private static int solve(TreeNode A) {
    AtomicInteger diameter = new AtomicInteger(0);
    getDiameter(A, diameter);

    return diameter.get();
  }
  public static void main(String[] args)
  {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);

   // System.out.print("The diameter of the tree is " + getDiameter(root));
    System.out.print("The diameter of the tree is " + solve(root));
  }
}

