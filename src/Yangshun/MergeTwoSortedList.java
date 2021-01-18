package Yangshun;

public class MergeTwoSortedList {

  /*
  Merge two sorted linked lists and return it as a sorted list.
  The list should be made by splicing together the nodes of the first two lists.
   */

  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode current = dummy;

    while(l1 != null || l2 != null) {
      if(l1.val > l2.val) {
        current.next = l2;
        l2 = l2.next;
      } else if (l2.val <= l1.val) {
        current.next = l1;
        l1 = l1.next;
      }
      current = current.next;
    }

    current.next = l1 == null ? l2: l1;
    return dummy.next;
  }

}
