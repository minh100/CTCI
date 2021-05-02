package Yangshun.SlidingWindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

  /** https://www.educative.io/courses/grokking-the-coding-interview/7D5NNZWQ8Wr
   *     Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
   *
   *     Input: Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
   *
   *         Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:
   *
   *         For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
   *         The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
   *         For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
   *         …
   *         Here is the final output containing the averages of all contiguous subarrays of size 5:
   *
   *     Output: [2.2, 2.8, 2.4, 3.6, 2.8]
   */

  // Uses sliding window
  // Essentially we need a way to keep track of the sum of 4 digits in the array
  // We simply subtract leaving element (begining of the window) from the 5 digit sum to get a 4 digit sum
  // Then we add the next entering element (new end of the winddow) from the new 4 digit sum
  public static double[] AverageOfSubarrayOfSizeK(int K, int[] arr) {
    double res[] = new double[arr.length - K + 1];          // the resulting array's size can be the amount of times to loop + 1 cause <= in condition
    double windowSum = 0;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];  // add element at end
      if(windowEnd >= K - 1) {  // get sum only if we have right size
        res[windowStart] = windowSum / K; // get average
        windowSum -= arr[windowStart];  // subtract beginning element
        windowStart++;                  // increment window starting
      }
    }

    return res;
  }

  public static void main(String[] args) {
    double[] result = AverageOfSubarrayOfSizeK(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }

  // brute force
  public static double[] BruteAverageOfSubarrayOfSizeK(int K, int[] arr) {
    double res[] = new double[arr.length - K + 1];  // the resulting array's size can be the amount of times to loop + 1 cause <= in condition
    for(int i = 0; i <= arr.length - K; i++) {    // we run the loop at most arr.length - K cause there is only so many K ways to get from an array
      double sum = 0;
      for(int j = i; j < i + K; j++ ) {
        sum += arr[j];
      }
      res[i] = sum/K; // calculate average
    }

    return res;
  }
}
