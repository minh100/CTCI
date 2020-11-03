public class LoopDetection8 {

  /*
    Check if a given linked list contains a loop
    A loop is defined as A -> B -> C -> D -> E -> F -> C
    Utilizes runner method / Floyd's Cycle Finding algo
   */

  static boolean loopFound(Node head) {
    Node fast = head;
    Node slow = head;

    while(slow != null && fast != null && slow.next != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if(fast == slow) {
        return true;
      }
    }

    return false;

  }
}
