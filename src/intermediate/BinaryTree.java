package intermediate.dec_14;
// non-recursive java program for inorder traversal
import java.util.ArrayList;
import java.util.Stack;

/* Class containing left and right child of
current node and key value*/
class TreeNode
{
    int val;
    TreeNode left, right;

    public TreeNode(int x)
    {
        val = x;
        left = right = null;
    }
}

/* Class to print the inorder traversal */
class BinaryTree
{
    TreeNode root;
    static int count;
    static  ArrayList<Integer>   inorder(TreeNode root)
    {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0)
        {
            while (curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    static ArrayList<Integer> preorderIterative(TreeNode node)
    {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        if (node == null)
        {
            return result;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = node;
        while (curr != null || !st.isEmpty())
        {
            while (curr != null)
            {
                result.add(curr.val);

                if (curr.right != null)
                    st.push(curr.right);

                curr = curr.left;
            }
            if (!st.isEmpty())
            {
                curr = st.pop();
            }
        }
        return result;
    }

    private static ArrayList<Integer> postOrderIterative(TreeNode root) {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if(stack.empty()) return result;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root) root = root.right;

            else {
                result.add(root.val);
                root = null;
            }
        }
    }

    int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    static int left_height(TreeNode node)
    {
        int ht = 0;
        while (node!=null) {
            ht++;
            node = node.left;
        }
        return ht;
    }
    static int right_height(TreeNode node)
    {
        int ht = 0;
        while (node!=null) {
            ht++;
            node = node.right;
        }
        return ht;
    }
    static int TotalNodes(TreeNode root)
    {
        if (root == null)
            return 0;
        int lh = left_height(root);
        int rh = right_height(root);

        if (lh == rh)
            return (1 << lh) - 1;

        return 1 + TotalNodes(root.left)
                + TotalNodes(root.right);
    }
    static int addBT(TreeNode root)
    {
        if (root == null)
            return 0;
        return (root.val + addBT(root.left) +
                addBT(root.right));
    }


    static void dfs(TreeNode node, int maxx)
    {
        // Base case
        if (node == null)
        {
            return;
        }
        else
        {

            // Increment the count if the current
            // node's value is greater than the
            // maximum value in it's ancestors
            if (node.val > maxx)
                count++;

            // Left traversal
            dfs(node.left, Math.max(maxx, node.val));

            // Right traversal
            dfs(node.right, Math.max(maxx, node.val));
        }
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(6);

        // To store the required count
        count = 0;

        dfs(tree.root, Integer.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE-->"+Integer.MIN_VALUE);
        System.out.print(count);

  /*
        tree.root = new TreeNode(1);
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left  = new TreeNode(9);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.left.right = new TreeNode(6);
        tree.root.left.right = new TreeNode(7);

        System.out.print(TotalNodes(tree.root));
      BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Height of tree is "
                + tree.maxDepth(tree.root));
		creating a binary tree and entering
		the nodes */
     /*   BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
      //  System.out.println("  Here "+ tree.inorder(tree.root));
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(20);
        tree.root.right = new TreeNode(30);
        tree.root.left.left = new TreeNode(40);
        tree.root.left.left.left = new TreeNode(70);
        tree.root.left.right = new TreeNode(50);
        tree.root.right.left = new TreeNode(60);
        tree.root.left.left.right = new TreeNode(80);

      //  tree.preorderIterative();
        System.out.println("  Here "+ tree.preorderIterative(tree.root));


        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("Post order traversal of binary tree is :");
        System.out.println("  Here "+tree.postOrderIterative(tree.root));

      */

    }
}
