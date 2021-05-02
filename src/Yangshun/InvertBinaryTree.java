package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

  /*  https://leetcode.com/problems/invert-binary-tree/
  Invert a binary tree.
    Example:

    Input:

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    Output:

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
   */

  // Essentially traverse the tree and swap the elements
  // Recursive Solution
  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return null;
    }

    invertTree(root.left);
    invertTree(root.right);

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
  }

  // Iterative Solution
  public TreeNode invertTreeIterative(TreeNode root) {
    if(root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(queue.isEmpty()) {
      TreeNode curr = queue.poll();
      TreeNode temp = curr.left;
      curr.left = curr.right;
      curr.right = temp;

      if(curr.left != null) queue.offer(curr.left);
      if(curr.right != null) queue.offer(curr.right);
    }

    return root;
  }
}
