package Yangshun;

public class RemoveNthNodeFromEnd {

  /*
  Given the head of a linked list, remove the nth node from the end of the list and return its head.

  Follow up: Could you do this in one pass?

  Example 1:


  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]
   */

  // two pointer method
  /*
  Input: head = [1,2,3,4,5], n = 2
                     S
                         F
  Output: [1,2,3,5]
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode slow = head;
    ListNode fast = head;

    while(n-- > 0) {
      fast = fast.next;
    }

    if(fast == null) {
      return head.next;
    }

    while(fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
  }
}
