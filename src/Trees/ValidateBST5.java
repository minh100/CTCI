public class ValidateBST5 {

  // Iterative solution
  public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    MyStack<TreeNode> stack = new MyStack<>();
    TreeNode pre = null;

    while(!stack.isEmpty() || root != null) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if(pre != null && root.val <= pre.val) {    // checks conditions that doesn't make a BST
        return false;
      }
      pre = root;
      root = root.right;
    }
    return true;
  }

  // Recursive Solution
  public boolean isValidBSTr(TreeNode root) {
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean helper(TreeNode root, long min, long max) {
    if(root == null) return true;

    if(root.val < min || root.val > max) {
      return false;
    }

    return helper(root.left, min, (long)root.val - 1) && helper(root.right, (long)root.val + 1, max);
  }



}
