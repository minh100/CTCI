public class Palindrome6 {

  /*
    Check to see if a list is a palindrome
    Simply reverse the list and check to see if they are the same
   */

  static boolean isPalindrome(Node head) {
    Node h = head;
    Node rev = reverse(head);
    return isEqual(h, rev);
  }

  static Node reverse(Node head) {
    Node prev = null;
    Node curr = head;
    Node next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
    Node clone = head;
    return clone;
  }

  static boolean isEqual(Node n1, Node n2) {
    while(n1 != null) {
      if(n1.data != n2.data) {
        return false;
      }
      n1 = n1.next;
      n2 = n2.next;
    }
    return true;
  }

  public static void main(String[] args) {
    Node n = new Node(1);
    n.next = new Node(2);
    n.next.next = new Node(2);
    n.next.next.next = new Node(1);

    System.out.println(isPalindrome(n));
  }
}
