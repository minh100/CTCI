package Yangshun;

public class HouseRobber2 {

  /*
  You are a professional robber planning to rob houses along a street.
  Each house has a certain amount of money stashed.
  All houses at this place are arranged in a circle.
  That means the first house is the neighbor of the last one.
  Meanwhile, adjacent houses have a security system connected,
  and it will automatically contact the police if two adjacent houses were broken into on the same night.
  Given a list of non-negative integers nums representing the amount of money of each house,
  return the maximum amount of money you can rob tonight without alerting the police.

  Example 1:

  Input: nums = [2,3,2]
  Output: 3
  Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
   */

  public static int rob(int[] nums) {
    // base cases
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return Math.max(nums[0],nums[1]);
    if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);  // we can only rob 1 house from 3 options due to the constraint of a cycle
    // here we decide to whether to include the first element and exclude the last or exclude the first and include the last
    return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
  }
  // essentially the same solution to house robber 1
  public static int rob1(int[] nums, int start, int end) {
    int[] dp = new int[end];
    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);
    for(int i = 2; i < end; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }

    return dp[end - 1];
  }

  public static void main(String[] args) {
    int array[] = {1,2,3,1};
    System.out.println(rob(array));
  }
}
