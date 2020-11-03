public class DeleteGivenNode3 {

  /*
    Delete a node in the middle
   */

  static boolean deleteGivenNode(Node head) {
    if (head == null || head.next == null) {
      return false;
    }

    Node n = head;

    // simply copy data from next to current and then set current next to next next
    // effectively deleting the "current" node
    Node following = n.next;
    n.data = following.data;
    n.next = following.next;

    return true;
  }
}
