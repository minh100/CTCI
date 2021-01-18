package Yangshun;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  /*
  Given an integer array nums, return the length of the longest strictly increasing subsequence.
  A subsequence is a sequence that can be derived from an array by deleting some or no elements
  without changing the order of the remaining elements.
  For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

  Example 1:

  Input: nums = [10,9,2,5,3,7,101,18]
  Output: 4
  Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
   */

  // Youtube video with explanation https://www.youtube.com/watch?v=CE2b_-XfVDk
  // using two pointers to traverse and find whenever the pointer i is greater than pointer j
  // then there is an increasing subsequence
  public int lengthOfLIS(int[] nums) {
    // base cases
    if(nums.length == 0 || nums == null) {
      return 0;
    }

    int dp[] = new int[nums.length];

    Arrays.fill(dp, 1);
    int res = 1;
    for(int i = 1; i < nums.length; i++) {
      for(int j = 0; j < i; j++) {
        if(nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
