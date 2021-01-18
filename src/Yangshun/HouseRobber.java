package Yangshun;

public class HouseRobber {

  /*
  You are a professional robber planning to rob houses along a street.
  Each house has a certain amount of money stashed,
  the only constraint stopping you from robbing each of them is that adjacent houses have security
  system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

  Given a list of non-negative integers representing the amount of money of each house,
  determine the maximum amount of money you can rob tonight without alerting the police.

  Example 1:

  Input: nums = [1,2,3,1]
  Output: 4
  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
               Total amount you can rob = 1 + 3 = 4.
   */

  public int rob(int[] nums) {
    // edge cases
    if( nums.length == 0 || nums == null) return 0;
    if( nums.length == 1) return nums[0];
    if( nums.length == 2) return Math.max(nums[0], nums[1]);

    int dp[] = new int[nums.length];
    dp[0] = nums[0];  // greatest you can rob from one house is the first element
    dp[1] = Math.max(nums[0], nums[1]); // greatest you can rob is the max between first and second element
    for(int i = 2; i < nums.length; i++) {  // start at 2 since we took care of 0 and 1 cases
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]); // calculate whether the greatest
    }                                                   // is from the current number + 2 spaces ago
                                                        // or only from one spaces ago
                                                        // this avoids the security constraint
    return dp[nums.length - 1];
  }
}
