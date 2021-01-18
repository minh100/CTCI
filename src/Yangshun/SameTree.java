package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

  /*
  Given the roots of two binary trees p and q, write a function to check if they are the same or not.

  Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

  Example 1:

  Input: p = [1,2,3], q = [1,2,3]
  Output: true
   */

  // Iterative solution
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(p);
    queue.offer(q);

    while(!queue.isEmpty()) {
      TreeNode first = queue.poll();
      TreeNode second = queue.poll();

      if(first == null && second == null) {
        continue;
      }
      else if(first == null || second == null || first.val != second.val) {
        return false;
      }

      queue.offer(first.left);
      queue.offer(second.left);
      queue.offer(first.right);
      queue.offer(second.right);
    }

    return true;
  }

  // Recursive solution
  public boolean isSameTreeRecursive(TreeNode p , TreeNode q) {
    if(p == null && q == null) return true;
    else if(p == null || q == null) return false;
    else if(p.val == q.val) {
      return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }else {
      return false;
    }
  }
}
