public class QueueTwoStacks4<T> {

  // Implement a queue using two stacks
  // Essentially what we want to do is to create a new stack and an old stack
  // the new stack will have the most recent items being pushed
  // when you want to poll or peek you simply move the items in newstack to the oldstack
  MyStack<T> stackNewest, stackOldest;

  public QueueTwoStacks4() {
    this.stackNewest = new MyStack<>();
    this.stackOldest = new MyStack<>();
  }

  public void add(T value) {
    this.stackNewest.push(value);
  }

  private void shiftStack() {
    if (stackOldest.isEmpty()) {
      while(!stackNewest.isEmpty()) {
        stackOldest.push(stackNewest.pop());
      }
    }
  }

  public T peek() {
    shiftStack();
    return this.stackOldest.peek();
  }

  public T pop() {
    shiftStack();
    return this.stackOldest.pop();
  }

}
