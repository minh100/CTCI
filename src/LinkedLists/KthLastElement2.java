public class KthLastElement2 {

  /*
    Find the kth to last element of a singly linked list
    Solution utilizes runner method
   */
  static Node kthTolast(Node head, int k){
    Node p1 = head;
    Node p2 = head;

    // runner method
    for(int i = 0; i < k; i++){
      if(p1 == null) return null; // out of bounds
      p1 = p1.next;
    }

    // moves both pointer at same space which will lead p2 to be at desired spot
    while(p1 != null){
      p1 = p1.next;
      p2 = p2.next;
    }

    return p2;

  }

  public static void main(String[] args){
    Node n = new Node(1);
    n.next = new Node(2);
    n.next.next = new Node(3);
    n.next.next.next = new Node(1);

    n.printList(n);

    Node res = kthTolast(n, 2);
    System.out.println(res.data);


  }
}
