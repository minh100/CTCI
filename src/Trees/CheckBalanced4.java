public class CheckBalanced4 {

  // Check if a binary tree is balanced
  // Balance is defined such as the heights of the two subtrees never differ by more than one
  public boolean checkBalance(TreeNode root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }

  // utilizes error pass backs to stop once an error is spotted
  // Time complexity is O(N)
  private int checkHeight(TreeNode node) {
    if(node == null) return -1;

    int leftHeight = checkHeight(node.left);
    if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int rightHeight = checkHeight(node.right);
    if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int diff = Math.abs(leftHeight-rightHeight);
    if(diff > 1) {
      return Integer.MIN_VALUE;   // error so pass back
    } else {
      return Math.max(leftHeight,rightHeight) + 1;
    }
  }
}
