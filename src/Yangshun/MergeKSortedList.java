package Yangshun;

import java.util.PriorityQueue;

public class MergeKSortedList {

  /*
  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
  Merge all the linked-lists into one sorted linked-list and return it.

  Example 1:

  Input: lists = [[1,4,5],[1,3,4],[2,6]]
  Output: [1,1,2,3,4,4,5,6]
  Explanation: The linked-lists are:
  [
    1->4->5,
    1->3->4,
    2->6
  ]
  merging them into one sorted list:
  1->1->2->3->4->4->5->6
   */

  // Essentially all you do is throw all the elements into a minheap which will be sorted
  // then you print out all the element in the minheap to a new ListNode and you have the new sorted list
  public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // initialize and declare minheap
    // put all elements into minheap
    for(ListNode head: lists) {
      while(head != null) {
        minHeap.add(head.val);
        head = head.next;
      }
    }

    ListNode dummy = new ListNode();  // create dummy as a place holder
    ListNode head = dummy;            // a pointer to add all the elements
    while(!minHeap.isEmpty()) {
      head.next = new ListNode(minHeap.remove());
      head = head.next;
    }

    return dummy.next;  // return next thing in the placeholder
  }
}
