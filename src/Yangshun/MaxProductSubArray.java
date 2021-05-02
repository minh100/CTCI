package Yangshun;

public class MaxProductSubArray {

  /*  https://leetcode.com/problems/maximum-product-subarray/
  Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

  Example 1:

  Input: [2,3,-2,4]
  Output: 6
  Explanation: [2,3] has the largest product 6.
   */

  // have to consider even and odd number of negative numbers
  public static int maxProduct(int[] nums) {

    int product = 1;
    int res = Integer.MIN_VALUE;

    // we make two for loops in order to determine if removing the first or last element will result in a larger number
    // this is a way to find the answer if given odd number we exclude at most one to make an even number
    for(int i = 0; i < nums.length; i++) {
      product = product * nums[i];
      res = Math.max(product, res);
      if(product == 0) {
        product = 1;
      }
    }

    product = 1;

    for(int i = nums.length - 1; i >= 0; i--) {
      product = product * nums[i];
      res = Math.max(product, res);
      if(product == 0) {
        product = 1;

      }
    }

    return res;
  }


}
