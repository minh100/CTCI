package Yangshun;

public class MaxSubArray {

  /*
  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

  Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

  Example 1:

  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
  Output: 6
  Explanation: [4,-1,2,1] has the largest sum = 6.
   */

  public static int maxSubArray(int[] nums) {

    int max = nums[0];
    int maxSoFar = nums[0];

    // Essentially find the max sum by seeing if the continuous elements make the greatest number
    for(int i = 1; i < nums.length; i++) {
      max = Math.max(nums[i], max + nums[i]); //checks to see if curr element is a greater sum
      maxSoFar = Math.max(maxSoFar, max);     // checks to see if maxSoFar is indeed the max so far
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(nums));
  }
}
