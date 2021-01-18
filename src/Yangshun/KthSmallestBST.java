package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.Stack;

public class KthSmallestBST {

  /*
  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

  Example 1:

  Input: root = [3,1,4,null,2], k = 1
     3
    / \
   1   4
    \
     2
  Output: 1
   */

  public int kthSmallest(TreeNode root, int k) {

    int count = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if(++count == k) return root.val;
      root = root.right;
    }

    return Integer.MIN_VALUE;
  }
}
