public class MinStack2 extends MyStack<Integer>{
  // Design a stack that also has a function to return the minimum element
  // Push, pop, min should operate in O(1) time

  MyStack<Integer> stack;
  public MinStack2(){
    this.stack = new MyStack<>();
  }

  public void push(int value) {
    if(value <= getMin()) {
      this.stack.push(value);
    }
    super.push(value);
  }

  public Integer pop(){
    Integer val = super.pop();
    if(val == getMin()) {
      this.stack.pop();
    }
    return val;
  }

  public int getMin() {
    if(this.stack.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return this.stack.peek();
  }
}
