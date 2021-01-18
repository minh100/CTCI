package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBinaryTree {

  /*
  Given the root of a binary tree, return its maximum depth.

  A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

  Example 1:

  Input: root = [3,9,20,null,null,15,7]
  Output: 3
   */

  public int maxDepth(TreeNode root) {
    if(root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    int count = 0;
    queue.offer(root);

    while(!queue.isEmpty()) {
      int size = queue.size();

      while(size-- > 0) {
        TreeNode curr = queue.poll();
        if(curr.left != null) queue.offer(curr.left);
        if(curr.right != null) queue.offer(curr.right);
      }

      count++;
    }

    return count;
  }
}
