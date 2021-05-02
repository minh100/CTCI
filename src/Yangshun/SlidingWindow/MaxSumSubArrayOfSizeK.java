package Yangshun.SlidingWindow;

public class MaxSumSubArrayOfSizeK {

  /** https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
   * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
   *
   * Example 1:
   *
   * Input: [2, 1, 5, 1, 3, 2], k=3
   * Output: 9
   * Explanation: Subarray with maximum sum is [5, 1, 3].
   * Example 2:
   *
   * Input: [2, 3, 4, 1, 5], k=2
   * Output: 7
   * Explanation: Subarray with maximum sum is [3, 4].
   */

  // sliding window approach
  public static int MaxSumSubArrayOfSizeK(int K, int[] arr) {
    int maxSum = 0;
    int windowSum = 0;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd];  // add the next element
      if(windowEnd >= K - 1) {        // slide the window, we don't need to slide if we've not hit the required window size of 'k'
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart];    // subtract the element going out
        windowStart++;                    // slide the window ahead
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 5, 1, 3, 2};
    int K = 3;
    System.out.println(MaxSumSubArrayOfSizeK(K, arr));
    int[] arr1 = new int[]{2, 3, 4, 1, 5};
    int K1 = 2;
    System.out.println(MaxSumSubArrayOfSizeK(K1, arr1));

  }

  // Brute force approach
  public static int BruteMaxSumSubArrayOfSizeK(int K, int[] arr) {
    int max = 0;
    for(int i = 0; i <= arr.length - K; i++) {  // number times to loop is at most how many K's array can fit in arr.length
      int sum = 0;
      for(int j = i; j < i + K; j++) {
        sum += arr[j];
      }
      max = Math.max(max, sum);
    }

    return max;
  }
}
