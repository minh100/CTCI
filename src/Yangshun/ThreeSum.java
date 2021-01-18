package Yangshun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  // https://www.youtube.com/watch?v=erEHQO0xljc Video Explanation

//  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//  Find all unique triplets in the array which gives the sum of zero.
//  Notice that the solution set must not contain duplicate triplets.
//
//  Example 1:
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]

//  Example 2:
//  Input: nums = []
//  Output:

//  Example 3:
//  Input: nums = [0]
//  Output: []


  // Solution using Set is slower
  public List<List<Integer>> threeSumSet(int[] nums) {

    Set<List<Integer>> res = new HashSet<>();

    // Edge case where no possible solutions
    if(nums.length < 3) {
      return new ArrayList<>(res);
    }

    Arrays.sort(nums);  // sorts the array o(n^2)

    for(int i = 0; i < nums.length - 2; i++) {  // nums.length - 2 to avoid index out of bounds when looking at next 2 elements
      int j = i + 1;
      int k = nums.length - 1;

      // inner loop to find 2 elements that when added with current element gives 0
      while(j<k) {
        int sum = nums[i]+nums[j]+nums[k];
        if(sum == 0) {
          res.add(Arrays.asList(nums[i],nums[j],nums[k]));
          // since we found two elements that work to equal 0 we can move the pointers
          j++;
          k--;
        }
        else if(sum > 0) k--; // sum is too large so decrement k pointer since sorted
        else if(sum < 0) j++; // sum is too small so increase j point since sorted
      }
    }

    return new ArrayList<>(res);
  }

  // Solution not using Set is faster
  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();

    // Edge case where no possible solutions
    if(nums.length < 3) {
      return res;
    }

    Arrays.sort(nums);  // sorts the array

    for(int i = 0; i < nums.length-2; i++) {  // nums.length - 2 to avoid index out of bounds when searching next 2 elements
      if(i > 0 && nums[i] == nums[i-1]) { // skip same result
        continue;
      }

      int j = i + 1;  // second pointer
      int k = nums.length - 1;  // third pointer from the end of array
      while(j < k) {
        int sum = nums[i]+nums[j]+nums[k];
        if(sum == 0) {
          res.add(Arrays.asList(nums[i],nums[j],nums[k]));

          // avoids duplicates
          while(j < k && nums[j] == nums[j+1]) j++;
          while(j < k && nums[k] == nums[k-1]) k--;
          j++;
          k--;
        }
        else if(sum < 0) {  // the sum is less than 0 so that means the second pointer is too far left due to sorting the array
          while(j < k && nums[j] == nums[j+1]) j++; //avoids duplicates
          j++;
        }
        else if(sum > 0) {  // the sum is greater than 0 so that means third pointer is too far right due to sorting the array
          while(j < k && nums[k] == nums[k-1]) k--; //avoids duplicates
          k--;
        }
      }

    }

    return res;


  }
}
