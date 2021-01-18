package Yangshun;

public class JumpGame {

  /*
  Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
  Each element in the array represents your maximum jump length at that position.
  Determine if you are able to reach the last index.

  Example 1:

  Input: nums = [2,3,1,1,4]
  Output: true
  Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   */

  // greedy algo 
  public boolean canJump(int[] nums) {
    int reachable = 0;
    for(int i = 0; i < nums.length; i++) {
      if( i > reachable) return false;
      reachable = Math.max(reachable, i + nums[i]);
    }

    return true;
  }
}
