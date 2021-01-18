package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

  /*
  Given two non-empty binary trees s and t,
  check whether tree t has exactly the same structure and node values with a subtree of s.
  A subtree of s is a tree consists of a node in s and all of this node's descendants.
  The tree s could also be considered as a subtree of itself.

  Example 1:                        Example 2:
  Given tree s:                     Given tree s:

       3                            3
      / \                          / \
     4   5                        4   5
    / \                          / \
   1   2                        1   2
  Given tree t:                      \
     4                                0
    / \
   1   2                        Given tree t is same in example 1
  Example 1: Return true, because t has the same structure and node values with a subtree of s.
  Example 2: Return false, because the 0 after the 2 in tree s
   */

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s == null) return false;
    if(isSame(s,t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSame(TreeNode s, TreeNode t) {
    if(s == null && t == null) return true;
    if(s == null || t == null || s.val != t.val) return false;
    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
