package Yangshun;

import Yangshun.ValidateBST.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializedDeserializeBinaryTrees {

  /*
  Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
  or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

  Design an algorithm to serialize and deserialize a binary tree.
  There is no restriction on how your serialization/deserialization algorithm should work.
  You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

  Example 1:

  Input: root = [1,2,3,null,null,4,5]
  Output: [1,2,3,null,null,4,5]
   */

  // we can use a stringbuilder for easy string creation
  // append commas as a seperator after each necessary values as for null we can use a special char

  public String serialize(TreeNode root) {
    StringBuilder stringBuilder = new StringBuilder();
    buildString(root, stringBuilder);
    return stringBuilder.toString();
  }

  // Encodes a tree to a single string.
  public void buildString(TreeNode root, StringBuilder stringBuilder) {
    if(root == null) {
      stringBuilder.append("#").append(",");
    } else {
      stringBuilder.append(root.val).append(",");
      buildString(root.left, stringBuilder);
      buildString(root.right, stringBuilder);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String str) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
    return buildTree(queue);
  }

  public TreeNode buildTree(Queue<String> queue) {
    String val = queue.poll();
    if(val.equals("#")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = buildTree(queue);
    root.right = buildTree(queue);
    return root;
  }
}
