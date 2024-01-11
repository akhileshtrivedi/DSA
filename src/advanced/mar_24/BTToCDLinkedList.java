package advanced.mar_24;

//class Node {
//  int val;
//  Node left, right;
//
//  public Node(int val)
//  {
//    this.val = val;
//    left = right = null;
//  }
//}

// A class to represent a tree
class Tree {
  TreeNode root;
  public Tree() { root = null; }

   TreeNode concatenate(TreeNode leftList, TreeNode rightList)
  {

    if (leftList == null)
      return rightList;
    if (rightList == null)
      return leftList;

    TreeNode leftLast = leftList.left;

    TreeNode rightLast = rightList.left;

    leftLast.right = rightList;
    rightList.left = leftLast;

    leftList.left = rightLast;

    rightLast.right = leftList;

    return leftList;
  }

   TreeNode bTreeToCList(TreeNode root)
  {
    if (root == null)
      return null;
    TreeNode left = bTreeToCList(root.left);
    TreeNode right = bTreeToCList(root.right);
    root.left = root.right = root;
    return concatenate(concatenate(left, root), right);
  }

//  public void display(TreeNode head)
//  {
//    System.out.println("Circular Linked List is :");
//    TreeNode itr = head;
//    do {
//      System.out.print(itr.val + " ");
//      itr = itr.right;
//    } while (itr != head);
//    System.out.println();
//  }
}

// Driver Code
class BTToCDLinkedList {
  public static void main(String args[])
  {
    //7 20 8 -1 -1 22 -1 -1
    // Build the tree
    Tree tree = new Tree();
    tree.root = new TreeNode(20);
    tree.root.left = new TreeNode(8);
    tree.root.right = new TreeNode(22);
   // tree.root.left.left = new Node(7);
   // tree.root.left.right = new Node(30);
   // tree.root.right.left = new Node(36);

    // head refers to the head of the Link List
    TreeNode head = tree.bTreeToCList(tree.root);

    // Display the Circular LinkedList
   // tree.display(head);
  }
}
