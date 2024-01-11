package advanced.mar_24;

import java.io.*;
    import java.util.*;

class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode() {}

  public TreeNode(int val) { this.val = val; }
}

class NodesDistanceKBinaryTree {
  List<TreeNode> path = null;
  //Finding all the nodes at a distance K from target
  //node.
  public List<Integer> distanceK(TreeNode root,
      int target, int K)
  {
    path = new ArrayList<>();
    findPath(root, target);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < path.size(); i++) {
      findKDistanceFromNode(
          path.get(i), K - i, result,
          i == 0 ? null : path.get(i - 1));
    }
    return result;
  }

  // Blocker is used for ancestors node if target at
  //left then we have to go in right or if target at
  // right then we have to go in left.
  public void findKDistanceFromNode(TreeNode node,
      int dist,
      List<Integer> result,
      TreeNode blocker)
  {
    if (dist < 0 || node == null
        || (blocker != null && node == blocker)) {
      return;
    }

    if (dist == 0) {
      result.add(node.val);
    }

    findKDistanceFromNode(node.left, dist - 1, result,
        blocker);
    findKDistanceFromNode(node.right, dist - 1, result,
        blocker);
  }
  //Finding the path of target node from root node
  public boolean findPath(TreeNode node, int target)
  {
    if (node == null)
      return false;

    if (node.val == target || findPath(node.left, target)
        || findPath(node.right, target)) {
      path.add(node);
      return true;
    }

    return false;
  }
  // Driver program to test the above functions
  public static void main(String[] args)
  {
    NodesDistanceKBinaryTree gfg = new NodesDistanceKBinaryTree();
    /* Let us construct the tree shown in above diagram */
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    TreeNode target = root.left.right;
    System.out.println(target.val);
    System.out.println(gfg.distanceK(root, 12, 2));
  }
}
