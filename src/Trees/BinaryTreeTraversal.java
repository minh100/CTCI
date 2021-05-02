import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

  public static void inorderTraversal(TreeNode head) {
    if(head != null) {
      inorderTraversal(head.left);
      System.out.print(head.val + " ");
      inorderTraversal(head.right);
    }
  }

  public static void inorderIterative(TreeNode head) {
    List<Integer> list = new ArrayList<>();
    if(head != null) {
      Stack<TreeNode> stack = new Stack<>();

      while(head != null || !stack.isEmpty()) {
        while(head!= null) {
          stack.push(head);
          head = head.left;
        }

        head = stack.pop();
        list.add(head.val);
        head = head.right;
      }
    }

    for(int i: list) {
      System.out.print(i + " ");
    }
  }

  public static void preorderTraversal(TreeNode head) {
    if(head != null) {
      System.out.print(head.val + " ");
      preorderTraversal(head.left);
      preorderTraversal(head.right);
    }
  }

  public static void postorderTraversal(TreeNode head) {
    if(head != null) {
      postorderTraversal(head.left);
      postorderTraversal(head.right);
      System.out.print(head.val + " ");
    }
  }

  public static void main(String args[]) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(3);
    t1.left.left = new TreeNode(4);
    t1.right.left = new TreeNode(5);
    t1.left.right = new TreeNode(6);

    System.out.println("Inorder Recursive");
    inorderTraversal(t1);

    System.out.println("\nInorder Iterative");
    inorderIterative(t1);

    System.out.println("\nPre-order Recursive");
    preorderTraversal(t1);

    System.out.println("\nPost-order Recursive");
    postorderTraversal(t1);
  }

}
