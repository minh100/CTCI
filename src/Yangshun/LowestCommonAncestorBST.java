package Yangshun;

import Yangshun.ValidateBST.TreeNode;

public class LowestCommonAncestorBST {

  /*
  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

  According to the definition of LCA on Wikipedia:
  “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
  that has both p and q as descendants (where we allow a node to be a descendant of itself).”
   */

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val < root.val && q.val < root.val) {  // p and q are on the left side
      return lowestCommonAncestor(root.left, p, q);
    }
    else if(p.val > root.val && q.val > root.val) { // p and q are on the right side
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;  // none of the two cases above means that the current root is the ancestor since
  }               // the elements split
}
