package Yangshun;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

  /*
  Median is the middle value in an ordered integer list.
  If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
  For example,
  [2,3,4], the median is 3

  [2,3], the median is (2 + 3) / 2 = 2.5

  Design a data structure that supports the following two operations:

  void addNum(int num) - Add a integer number from the data stream to the data structure.
  double findMedian() - Return the median of all elements so far.
   */

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap; // large holds more elements
  public MedianFinder() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    maxHeap.offer(num);       // gives num to maxHeap
    minHeap.offer(maxHeap.remove());  // balances minHeap
    if(maxHeap.size() < minHeap.size()) { // balance maxHeap if needed
      maxHeap.offer(minHeap.remove());
    }
  }

  public double findMedian() {
    if(maxHeap.size() == minHeap.size()) {  // if same size then it is even so find average
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    return maxHeap.peek();
  }
}
