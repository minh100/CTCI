package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  /*
  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
  return its level order traversal as:
  [
    [3],
    [9,20],
    [15,7]
  ]
   */

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();  // return value
    if(root == null) return res;  // edge case

    Queue<TreeNode> queue = new LinkedList<>(); // using queue for fifo
    queue.offer(root);                          // why fifo so we can get all elements in a single level

    while(!queue.isEmpty()){
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      while(size-- > 0) {                       // find the size and iterate through all the nodes
        TreeNode curr = queue.poll();
        currentLevel.add(curr.val);
        if(curr.left != null) queue.add(curr.left);
        if(curr.right != null) queue.add(curr.right);
      }
      res.add(currentLevel);
    }
    return res;
  }
}
