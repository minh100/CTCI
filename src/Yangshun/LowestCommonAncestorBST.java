package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import com.sun.source.tree.Tree;
import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorBST {

  /*  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

  According to the definition of LCA on Wikipedia:
  “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
  that has both p and q as descendants (where we allow a node to be a descendant of itself).”

  Example:
  Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
  Output: 3
  Explanation: The LCA of nodes 5 and 1 is 3.
   */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p , q);
    TreeNode right = lowestCommonAncestor(root.right, p , q);
    if(left != null && right != null) return root;
    return left != null ? left: right;
  }
}
