package advanced.mar_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {

    int val;
    TreeNode1 left, right;

    public TreeNode(int item) {
      val = item;
      left = null;
      right = null;
    }
  }
    public class LevelOrder {
      TreeNode1 root;

    private static ArrayList<ArrayList<Integer>> solve(TreeNode1 root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    if(root==null){
      return result;
    }

    LinkedList<TreeNode1> nodeQueue = new LinkedList<>();
    LinkedList<Integer> levelQueue = new LinkedList<>();

    nodeQueue.offer(root);
    levelQueue.offer(1);//start from 1

    while(!nodeQueue.isEmpty()){
      TreeNode1 node = nodeQueue.poll();
      int level = levelQueue.poll();

      ArrayList<Integer> l=null;
      if(result.size()<level){
        l = new ArrayList<>();
        result.add(l);
      }else{
        l = result.get(level-1);
      }

      l.add(node.val);

      if(node.left!=null){
        nodeQueue.offer(node.left);
        levelQueue.offer(level+1);
      }

      if(node.right!=null){
        nodeQueue.offer(node.right);
        levelQueue.offer(level+1);
      }
    }

    return result;
  }
      void printLevelOrder()
      {
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
          TreeNode1 tempNode = queue.poll();
          System.out.print(tempNode.val + " ");

          /*Enqueue left child */
          if (tempNode.left != null) {
            queue.add(tempNode.left);
          }

          /*Enqueue right child */
          if (tempNode.right != null) {
            queue.add(tempNode.right);
          }
        }
      }
    public static void main(String[] args) {
LevelOrder tree_level = new LevelOrder();
      tree_level.root = new TreeNode1(1);
      tree_level.root.left = new TreeNode1(6);
      tree_level.root.right = new TreeNode1(2);
      tree_level.root.left.left = new TreeNode1(3);
     // tree_level.root.left.right = new TreeNode(5);

      System.out.println("Level order traversal of binary tree is - "+solve(tree_level.root));
    //  tree_level.printLevelOrder();
    }
}
