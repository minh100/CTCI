public class Palindrome6 {

  /*
    Check to see if a list is a palindrome
    First, using two runner method get to the right half of the list
    reverse the right half
    compare
   */

  static boolean isPalindrome(Node head) {
    Node fast = head;
    Node slow = head;

    // gets slow to the half position
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // odd nodes
    if(fast != null) {
      slow = slow.next;
    }

    // reverse the right half
    Node end = reverse(slow);
    Node start = head;

    // compare
    while(end != null) {
      if(start.data != end.data) return false;

      end = end.next;
      start = start.next;

    }

    return true;
  }

  static Node reverse(Node n) {
    Node prev = null;
    Node curr = n;
    Node next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node clone = prev;

    return clone;
  }


  public static void main(String[] args) {
    Node n = new Node(1);
    n.next = new Node(2);
    n.next.next = new Node(2);
    n.next.next.next = new Node(1);

    System.out.println(isPalindrome(n));
  }
}
