package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTree {

  /*
  Given preorder and inorder traversal of a tree, construct the binary tree.

  Note:
  You may assume that duplicates do not exist in the tree.

  For example, given

  preorder = [3,9,20,15,7]
  inorder = [9,3,15,20,7]
  Return the following binary tree:

      3
     / \
    9  20
      /  \
     15   7
   */

//  The basic idea is here:
//  Say we have 2 arrays, PRE and IN.
//  Preorder traversing implies that PRE[0] is the root node.
//  Then we can find this PRE[0] in IN, say it's IN[5].
//  Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
//  Recursively doing this on subarrays, we can build a tree out of it
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();

    // build a map of the indices of the values as they appear in the inorder array
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, 0, inorder.length - 1, map);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
    if(inStart > inEnd) {
      return null;
    }

    int rootVal = preorder[preStart];
    TreeNode root = new TreeNode(rootVal);
    int inRoot = map.get(rootVal);

    root.left = buildTree(preorder, preStart + 1, inStart, inRoot - 1, map);
    root.right = buildTree(preorder, preStart + (inRoot - inStart) + 1, inRoot + 1, inEnd, map);

    return root;
  }

  // Iterative Solution
  public TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
    // edge cases
    if(preorder.length == 0) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    Stack<TreeNode> stack = new Stack<>();
    int val = preorder[0];
    TreeNode root = new TreeNode(val);
    stack.push(root);

    for(int i = 1; i < preorder.length; i++) {
      val = preorder[i];
      TreeNode node = new TreeNode(val);

      if(map.get(val) < map.get(stack.peek().val)) {  // new node is on left side
        stack.peek().left = node;                     // so must be left child
      }
      else {                                          // new node is on right side
        TreeNode parent = null;
        while(!stack.isEmpty() && map.get(val) > map.get(stack.peek().val)) {
          parent = stack.pop();
        }
        parent.right = node;
      }
      stack.push(node);
    }
    return root;
  }
}
