public class Intersection7 {

  /*
    Given two singly linked list, determine if the two lists intersect
    Return intersecting Node
    Intersecting is defined based on reference not value
    ref: https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
   */

  static Node findIntersection(Node list1, Node list2) {
    int lenA = getCount(list1);
    int lenB = getCount(list2);

    while(lenA > lenB) {
      list1 = list1.next;
      lenA--;
    }

    while(lenB > lenA) {
      list2 = list2.next;
      lenB--;
    }

    while (list1 != list2) {
      list1 = list1.next;
      list2 = list2.next;
    }

    return list1;

  }

  // returns the size of the lists
  static int getCount(Node list1) {
    int size = 0;
    Node curr = list1;
    while(curr != null) {
      size++;
      curr = curr.next;
    }
    return size;
  }

  public static void main(String[] args) {
    Node n = new Node(4);
    n.next = new Node(1);
    n.next.next = new Node(8);
    n.next.next.next = new Node(4);
    n.next.next.next.next = new Node(5);

    Node nt = new Node(5);
    nt.next = new Node(6);
    nt.next.next = new Node(1);
    nt.next.next.next = new Node(8);
    nt.next.next.next.next = new Node(4);
    nt.next.next.next.next.next = new Node(5);

    System.out.println(findIntersection(n, nt));
  }

}
