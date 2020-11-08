import java.util.ArrayList;
import java.util.EmptyStackException;

class NodeStack {

  public NodeStack above, below;
  public int value;

  public NodeStack(int v) {
    this.value = v;
  }
}

class Stack {

  private int capacity;
  public NodeStack top, bottom;
  public int size = 0;

  public Stack(int capacity) {
    this.capacity = capacity;
  }

  public boolean isFull() {
    return this.capacity == this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void join(NodeStack above, NodeStack below) {
    if (below != null) {
      below.above = above;
    }
    if (above != null) {
      above.below = below;
    }
  }

  public boolean push(int v) {
    if (this.size >= this.capacity) {
      return false;
    }
    this.size++;
    NodeStack n = new NodeStack(v);
    if (this.size == 1) {
      this.bottom = n;
    }
    join(n, this.top);
    this.top = n;
    return true;
  }

  public int pop() {
    NodeStack t = this.top;
    this.top = this.top.below;
    size--;
    return t.value;
  }

  public int removeBottom() {
    NodeStack b = this.bottom;
    this.bottom = this.bottom.above;
    if (this.bottom != null) {
      this.bottom.below = null;
    }
    size--;
    return b.value;
  }
}

// Implement a class where a stack has a capacity and pushing it pass that capacity will create a
// new stack

public class StackOfPlates3 {
  ArrayList<Stack> stacks = new ArrayList<>();
  public int capacity;
  public StackOfPlates3(int capacity){
    this.capacity = capacity;
  }

  public Stack getLastStack(){
    if(this.stacks.size() == 0) {
      return null;
    }
    return this.stacks.get(stacks.size() - 1);
  }

  public void push(int v) {
    Stack last = getLastStack();
    if(last != null && !last.isFull()) {
      last.push(v);
    } else {
      Stack stack = new Stack(this.capacity);
      stack.push(v);
      stacks.add(stack);
    }
  }

  public int pop(){
    Stack last = getLastStack();
    if(last == null) throw new EmptyStackException();
    int v = last.pop();
    if(last.size == 0) stacks.remove(stacks.size() - 1);
    return v;
  }

  public boolean isEmpty(){
    Stack last = getLastStack();
    return last == null || last.isEmpty();
  }

  public int popAt(int index) {
    return leftShift(index, true);
  }

  public int leftShift(int index, boolean removeTop) {
    Stack stack = stacks.get(index);
    int removedItem;
    if(removeTop) removedItem = stack.pop();
    else {
      removedItem = stack.removeBottom();
    }

    if(stack.isEmpty()) {
      stacks.remove(index);
    } else if (stack.size > index + 1) {
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return removedItem;
  }



}




