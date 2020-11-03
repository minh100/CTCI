import java.util.HashSet;

public class RemoveDups1 {

  /*
    Remove duplicates of an unsorted list
   */

  public static void removeDuplicates(Node head){
    HashSet<Integer> set = new HashSet<>();
    Node n = head;
    Node prev = null;

    while(n != null){
      if(set.contains(n.data)){
        prev.next = n.next;
      } else {
        set.add(n.data);
        prev = n;
      }
      n = n.next;
    }
  }

  public static void main(String[] args){
    Node n = new Node(1);
    n.next = new Node(2);
    n.next.next = new Node(3);
    n.next.next.next = new Node(1);

    n.printList(n);

    removeDuplicates(n);

    n.printList(n);
  }
}
