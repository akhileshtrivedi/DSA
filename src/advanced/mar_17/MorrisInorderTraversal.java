package advanced.mar_17;

// Java program to print inorder
// traversal without recursion
// and stack

import java.util.ArrayList;

/* A binary tree tNode has data,
a pointer to left child
and a pointer to right child */
class tNode {

  int data;
  tNode left, right;

  tNode(int item) {
    data = item;
    left = right = null;
  }
}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
    left = null;
    right = null;
  }
}

class MorrisInorderTraversal {

  TreeNode root;

  /* Function to traverse a
  binary tree without recursion
  and without stack */
  void MorrisTraversal(tNode root) {
    tNode current, pre;

    if (root == null) {
      return;
    }

    current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data + " ");
        current = current.right;
      } else {
				/* Find the inorder
					predecessor of current
				*/
        pre = current.left;
        while (pre.right != null
            && pre.right != current) {
          pre = pre.right;
        }

				/* Make current as right
				child of its
				* inorder predecessor */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        }

				/* Revert the changes made
				in the 'if' part
				to restore the original
				tree i.e., fix
				the right child of predecessor*/
        else {
          pre.right = null;
          System.out.print(current.data + " ");
          current = current.right;
        } /* End of if condition pre->right == NULL
         */

      } /* End of if condition current->left == NULL*/

    } /* End of while */
  }

  public ArrayList<Integer> solve(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    TreeNode current, pre;

    if (root == null) {
      return ans;
    }

    current = root;
    while (current != null) {
      if (current.left == null) {
        ans.add(current.val);
        System.out.print(current.val + " ");
        current = current.right;
      } else {
        pre = current.left;
        while (pre.right != null
            && pre.right != current) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        }
        else {
          pre.right = null;
          ans.add(current.val);
          System.out.print(current.val + " ");
          current = current.right;
        }
      }
    }
    return ans;
  }

  // Driver Code
  public static void main(String args[]) {
		/* Constructed binary tree is
			1
			/ \
			2	 3
		/ \
		4	 5
		*/
    MorrisInorderTraversal tree = new MorrisInorderTraversal();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(5);

   // tree.MorrisTraversal(tree.root);
    System.out.println(" " +tree.solve(tree.root));
  }
}

// This code has been contributed by Mayank
// Jaiswal(mayank_24)
