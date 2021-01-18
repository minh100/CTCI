package Yangshun;

public class ReverseLinkList {

  public static ListNode reverseList(ListNode head) {

    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;

    while(curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;

    return head;
  }

  public static void main(String[] args) {
    ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    while(list != null) {
      System.out.println(list.val);
      list = list.next;
    }

    ListNode reversed = reverseList(list);
    System.out.println("-----");
    while(reversed != null) {
      System.out.println(reversed.val);
      reversed = reversed.next;
    }

  }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }