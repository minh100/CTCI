package Yangshun;

public class SearchInRotatedSortedArray {

  /*
  You are given an integer array nums sorted in ascending order, and an integer target.

  Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

  If target is found in the array return its index, otherwise, return -1.

  Example 1:

  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
   */

  // the problem with this question is that the array is pivoted so regular binary search will not work
  // to solve this we need to find the pivot point and then we can do binary search for the number since we know the target is within range
  public int search(int[] nums, int target) {

    if(nums.length == 0) return -1; // edge case

    int left = 0;
    int right = nums.length - 1;

    while(left < right) {
      int mid = (left + right) / 2; // mid index

      if(nums[mid] == target) {     // if found
        return mid;
      }

      // check to see if nums[mid] and the target are in different sides
      boolean split = (nums[mid] >= nums[0]) != (target >= nums[0]);

      if(split) {
        if(target >= nums[0]) {
          right = mid;
        }
        else {
          left = mid + 1;
        }
      } else {  // if not split just a normal binary search
        if(target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

    }

    return nums[left] == target ? left : -1;
  }
}
