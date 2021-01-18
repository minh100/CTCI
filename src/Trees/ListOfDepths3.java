import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths3 {
  // Given a binary tree, design an algo which creates a linked list of all the nodes at each depth
  // Example: given a tree with D depth, return D linked lists

  // Breath First Solution
  public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();

    LinkedList<TreeNode> current = new LinkedList<>();
    if(root != null){
      current.add(root);
    }

    while(current.size() > 0) {
      res.add(current);   // adds previous levels
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for(TreeNode parent: parents) {
        // Visit children
        if(parent.left != null) {
          current.add(parent.left);
        }
        if(parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return res;
  }

  // Depth First Solution
  public ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
    createLevelLinkedList(root, res, 0);
    return res;
  }

  private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if(root == null) return;

    LinkedList<TreeNode> list = null;
    if(list.size() == level) {
      list = new LinkedList<>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(root);
    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
  }
}
