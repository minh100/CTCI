public class Intersection7 {

  /*
    Given two singly linked list, determine if the two lists intersect
    Return intersecting Node
    Intersecting is defined based on reference not value
    ref: https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
   */

  static Node findIntersection(Node list1, Node list2) {
    // get the size of each list
    int size1 = getCount(list1);
    int size2 = getCount(list2);

    // call the getIntersectionNode depending on which list is larger
    if(size1 > size2) {
      int diff = size1 - size2;
      return getIntersectionNode(diff, list1, list2);
    } else {
      int diff = size2 - size1;
      return getIntersectionNode(diff, list2, list1);
    }

  }

  // The acutal method to find the Node
  static Node getIntersectionNode(int diff, Node longer, Node shorter){
    Node longlist = longer;
    Node shortlist = shorter;

    // advance the longer list until it reaches same length as the shorter list
    for(int i = 0; i < diff; i++) {
      if(longlist == null) return null;
      longlist = longlist.next;
    }

    // loop until the short and long list has the same data
    while(longlist != null || shortlist != null){
      if(longlist.data == shortlist.data) {
        return longlist;
      }
      longlist = longlist.next;
      shortlist = shortlist.next;
    }

    return null;
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
    Node n = new Node(3);
    n.next = new Node(1);
    n.next.next = new Node(5);
    n.next.next.next = new Node(9);
    n.next.next.next.next = new Node(7);
    n.next.next.next.next.next = new Node(2);
    n.next.next.next.next.next.next = new Node(1);

    Node nt = new Node(4);
    nt.next = new Node(6);
    nt.next.next = new Node(7);
    nt.next.next.next = new Node(2);
    nt.next.next.next.next = new Node(1);

    System.out.println(findIntersection(n, nt).data);
  }

}
