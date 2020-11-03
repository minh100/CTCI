public class Partition4 {

  /*
    Partition a linked list around a value x
    All elements left of the partition are those less than x
    All elements right of the partition are those greater than x
   */
  static Node partition(Node node, int x) {
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;

    while (node != null) {
      Node next = node.next;
      node.next = null;

      if(node.data < x) {
        if(beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        if(afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    //if value of x is at beginning of linkedList
    if(beforeStart == null) {
      return afterStart;
    }

    //merge two linkedLists
    beforeEnd.next = afterStart;

    return beforeStart;
  }
}
