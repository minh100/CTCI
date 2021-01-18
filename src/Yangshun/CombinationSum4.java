package Yangshun;

public class CombinationSum4 {

  /*
  Given an integer array with all positive numbers and no duplicates,
  find the number of possible combinations that add up to a positive integer target.

  Example:

  nums = [1, 2, 3]
  target = 4

  The possible combination ways are:
  (1, 1, 1, 1)
  (1, 1, 2)
  (1, 2, 1)
  (1, 3)
  (2, 1, 1)
  (2, 2)
  (3, 1)

  Note that different sequences are counted as different combinations.

  Therefore the output is 7.
   */

  // Recursive solution
  public int combinationSum4(int[] nums, int target) {
    // base case
    if(target == 0) {
      return 1;
    }

    int res = 0;
    for(int i = 0; i < nums.length; i++) {
      if(target >= nums[i]) {
        res += combinationSum4(nums, target - nums[i]);
      }
    }
    return res;
  }

  // DP solution
  public int combinationSum4DP(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for(int i = 0; i <= target; i++) {
      for(int n : nums) {
        if( i >= n) {
          dp[i] += dp[i - n];
        }
      }
    }
    return dp[target];
  }
}
