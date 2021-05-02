package Yangshun;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  /*
  Given an array nums of n integers where n > 1,
  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

  Example:

  Input:  [1,2,3,4]
  Output: [24,12,8,6]
   */

// First Attempt but fails cases where nums length is too long this is an O(n^2) solution
//  public static int[] productExceptSelf(int[] nums) {
//
//    int[] res = new int[nums.length];
//
//    for(int i = 0; i < nums.length; i++) {
//      int product = 1;
//
//      for(int j = 0; j < nums.length; j++) {
//        if(j != i) {
//          product *= nums[j];
//        }
//      }
//
//      res[i] = product;
//
//    }
//
//    return res;
//  }

  public static int[] productExceptSelf(int[] nums){
    int[] res = new int[nums.length];

    // calculate the left side first
    int left = 1;
    for(int i = 0; i < nums.length; i++) {
      if(i> 0) {  // skips the left most
        left = left * nums[i-1];
      }
      res[i] = left;
    }

    // multiply the right to the left for answer
    int right = 1;
    for(int j = nums.length - 1; j >= 0; j--) {
      if(j < nums.length - 1) { // skips the right most
        right = right * nums[j+1];
      }
      res[j] *= right;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] a = {1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(a)));
  }

}
