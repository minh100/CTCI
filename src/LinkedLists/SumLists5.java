public class SumLists5 {

  /*
    Given two numbers represented by a linked list, where each node is a single digit
    The digits are stored in reverse order such that the 1's place is the head of the list
    Create a function that adds the two numbers and returns the sums as a linked list
   */

  static Node addLists(Node n1, Node n2) {
    return addLists(n1, n2, 0);
  }

  private static Node addLists(Node n1, Node n2, int carry) {
    if (n1 == null && n2 == null && carry == 0) {
      return null;
    }

    Node res = new Node(0);
    int val = carry;

    // sums the digits of each node in each list and checks if there are no values
    if (n1 != null) {
      val += n1.data;
    }
    if (n2 != null) {
      val += n2.data;
    }

    res.data = val % 10;  // the digit is stored into a list

    // recursive calling
    if (n1 != null || n2 != null) {
      Node more = addLists(
          n1 == null ? null : n1.next,
          n2 == null ? null : n2.next,
          val >= 10 ? 1 : 0
      );

      res.next = more;
    }

    return res;

  }
}
