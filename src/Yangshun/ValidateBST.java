package Yangshun;

import java.util.Stack;

public class ValidateBST {


  /*
  Given the root of a binary tree, determine if it is a valid binary search tree (BST).

  A valid BST is defined as follows:

  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees.

  Example 1:

  Input: root = [2,1,3]
  Output: true
   */

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // Essentially to solve this problem we need to make and check a range so that the current node value satisfies a bst
  // Recursive solution
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MAX_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, long min, long max) {
    if(root == null) {
      return true;
    }

    if(root.val < min || root.val > max) {
      return false;
    }

    return isValidBST(root.left, min, (long)root.val - 1) && isValidBST(root.right, (long)root.val + 1, max);
  }

  // Iterative solution
  public boolean isValidBSTIterative(TreeNode root) {
    if(root == null) return true;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if(pre != null && root.val <= pre.val) {
        return false;
      }
      pre = root;
      root = root.right;

    }

    return true;
  }



}
