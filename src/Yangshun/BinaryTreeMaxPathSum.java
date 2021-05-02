package Yangshun;

import Yangshun.ValidateBST.TreeNode;

public class BinaryTreeMaxPathSum {

  /*  https://leetcode.com/problems/binary-tree-maximum-path-sum/
  Given a non-empty binary tree, find the maximum path sum.

  For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections.
  The path must contain at least one node and does not need to go through the root.
   */

  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
  }

  public int helper(TreeNode root) {
    if(root == null) return 0;

    int left = Math.max(0, helper(root.left));  // why comparing 0 to deal with negatives
    int right = Math.max(0, helper(root.right));

    max = Math.max(max, left + right + root.val);

    return root.val + Math.max(left,right);
  }
}
