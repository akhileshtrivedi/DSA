package advanced.mar_10;

// A Java program to demonstrate serialization and
// deserialization of Binary Tree

import java.util.*;

// A binary tree Node has key,
// pointer to left and right children
class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1(int x) { val = x; }
}

class SerializeBinaryTree {
  TreeNode1 root;

  // Encodes a tree to a single string.
  public static String serialize(TreeNode1 root)
  {
    if (root == null) {
      return null;
    }
    Stack<TreeNode1> s = new Stack<>();
    s.push(root);

    List<String> l = new ArrayList<>();
    while (!s.isEmpty()) {
      TreeNode1 t = s.pop();
      if (t == null) {
        l.add("-1");
      }
      else {
        l.add("" + t.val);
        s.push(t.right);
        s.push(t.left);
      }
    }
    return String.join(",", l);
  }

  static int t;

  // Decodes your encoded data to tree.
  public static TreeNode1 deserialize(String data)
  {
    if (data == null)
      return null;
    t = 0;
    String[] arr = data.split(",");
    return helper(arr);
  }

  public static TreeNode1 helper(String[] arr)
  {
    if (arr[t].equals("-1"))
      return null;

    // Create node with this item
    // and recur for children
    TreeNode1 root
        = new TreeNode1(Integer.parseInt(arr[t]));
    t++;
    root.left = helper(arr);
    t++;
    root.right = helper(arr);
    return root;
  }

  // A simple inorder traversal used
  // for testing the constructed tree
  static void inorder(TreeNode1 root)
  {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.val + " ");
      inorder(root.right);
    }
  }
  private static ArrayList<Integer> solve(TreeNode1 root) {
      if (root == null) {
        return null;
      }
      Queue<TreeNode1> q = new LinkedList<>();
      q.add(root);
      ArrayList<Integer> result = new ArrayList<Integer>();

      while (q.size()!=0) {
        TreeNode1 t = q.peek();
        q.remove();
        if (t == null) {
          result.add(-1);
          continue;
        }
        result.add(t.val);
        q.add(t.left);
        q.add(t.right);
      }
      return result;
    }
  private static TreeNode1 solve2(ArrayList<Integer> A) {
    if (A.size() == 0) return null;
    Queue<TreeNode1> q = new LinkedList<>();
    TreeNode1 root = new TreeNode1(A.get(0));
    q.add(root);
    for (int i = 1; i < A.size(); i++) {
      TreeNode1 parent = q.poll();
      if (A.get(i)!=-1) {
        TreeNode1 left = new TreeNode1(A.get(i));
        parent.left = left;
        q.add(left);
      }
      if (A.get(++i)!=-1) {
        TreeNode1 right = new TreeNode1(A.get(i));
        parent.right = right;
        q.add(right);
      }
    }
    return root;
  }
  // Driver code
  public static void main(String args[])
  {
    // Construct a tree shown in the above figure
    SerializeBinaryTree tree = new SerializeBinaryTree();
    tree.root = new TreeNode1(20);
    tree.root.left = new TreeNode1(8);
    tree.root.right = new TreeNode1(22);
    tree.root.left.left = new TreeNode1(4);
    tree.root.left.right = new TreeNode1(12);
    tree.root.left.right.left = new TreeNode1(10);
    tree.root.left.right.right = new TreeNode1(14);

    String serialized = serialize(tree.root);
    System.out.println("Serialized view of the tree:"+solve(tree.root));
    System.out.println("Serialized view of the tree:");
    System.out.println(serialized);
    System.out.println();

    // Deserialize the stored tree into root1
    TreeNode1 t = deserialize(serialized);

    System.out.println(
        "Inorder Traversal of the tree constructed"
            + " from serialized String:");
    inorder(t);
  }
}
