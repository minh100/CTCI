public class Node {
  Node next = null;
  int data;

  public Node(int d){
    data = d;
  }

  public void appendToTail(int d){
    Node end = new Node(d);
    Node n = this;
    while(n.next != null){
      n = n.next;
    }
    n.next = end;
  }

  public Node deleteNode(Node head, int d){
    if(head == null) return null;
    Node n = head;

    if(n.data == d) {
      return n.next;
    }

    while (n.next != null){
      if(n.data == d) {
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head;
  }

  public void printList(Node head){
    while(head != null){
      System.out.println(head.data);
      head = head.next;
    }
  }
}
