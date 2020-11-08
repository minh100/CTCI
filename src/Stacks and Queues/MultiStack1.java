import java.util.EmptyStackException;

public class MultiStack1 {

  // Use single array to implement three stacks

  private int numOfStacks = 3;
  private int stackCap;
  private int[] values;
  private int[] sizes;

  public MultiStack1(int stackSize) {
    this.stackCap = stackSize;
    values = new int[stackSize * numOfStacks];
    sizes = new int[stackSize];
  }

  public void push(int stackNum, int val) throws Exception {
    if (isFull(stackNum)) {
      throw new Exception();
    }

    sizes[stackNum]++;
    values[indexOfTop(stackNum)] = val;
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int topIndex = indexOfTop(stackNum);
    int val = this.values[topIndex];  // top value
    this.values[topIndex] = 0;        // Clear
    sizes[stackNum]--;                // shrink
    return val;
  }

  public int peek(int stackNum) {
    if(isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    return this.values[indexOfTop(stackNum)];
  }

  /* Helper Functions */
  public boolean isEmpty(int stackNum) {
    return this.sizes[stackNum] == 0;
  }

  public boolean isFull(int n) {
    return n == this.stackCap;
  }

  public int indexOfTop(int n) {
    int offset = stackCap * n;
    int size = sizes[n];
    return offset + size - 1;
  }
}
