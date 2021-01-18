package Yangshun;

public class MinInRotatedSortedArray {

  /*
  Suppose an array of length n sorted in ascrighting order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

  [4,5,6,7,0,1,2] if it was rotated 4 times.
  [0,1,2,4,5,6,7] if it was rotated 7 times.
  Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

  Given the sorted rotated array nums, return the minimum element of this array.

  Example 1:

  Input: nums = [3,4,5,1,2]
  Output: 1
  Explanation: The original array was [1,2,3,4,5] rotated 3 times.
   */

  // minimum element must satisfy one of two conditions:
  // 1) if rotated, nums[mid] < nums[mid - 1] due to array being sorted and rotated
  // 2) if not rotated then min element is at index 0
  // additionally we can check which side the minimum element is located if it is rotated
  // 1) if the left index element is less than the mid number and the mid number is greater than the right index element
  //      than we know the element is on the right
  //      for example [4,5,6,7,0,1,2]
  // 2) else the element is on the left
  public int findMin(int[] nums) {

    // edge cases
    if(nums == null || nums.length == 0) {
      return 0;
    }

    if(nums.length == 1) {
      return nums[0];
    }

    int left = 0;
    int right = nums.length - 1;

    while(left < right) {
      int mid = (left + right) / 2;

      if(mid > 0 && nums[mid] < nums[mid - 1]) { // if nums[mid] < nums[mid - 1] is true then min found
        return nums[mid];                        // this is true do to the array being sorted and rotated
      }
      else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) {  // we know this due to the array being sorted and rotated
        left = mid + 1;
      }
      else{
        right = mid - 1;
      }
    }

    return nums[left];
  }
}
