public class SortStack5 {
  // implement a program that sorts a stack which the smallest items are on the top

  public void sort(MyStack<Integer> s) {
    MyStack<Integer> r= new MyStack();
    while(!s.isEmpty()) {
      int temp = s.pop();
      while(!r.isEmpty() && r.peek() > temp) {
        s.push((r.pop()));
      }
      r.push(temp);
    }

    while(!r.isEmpty()) {
      s.push(r.pop());
    }
  }
}
