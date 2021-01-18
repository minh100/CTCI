package Yangshun;

public class ClimbingStairs {

  /*
  You are climbing a staircase. It takes n steps to reach the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

  Example 1:

  Input: n = 2
  Output: 2
  Explanation: There are two ways to climb to the top.
  1. 1 step + 1 step
  2. 2 steps
   */

  public int climbStairs(int n) {
    // base cases
    if(n < 3) return n;
    int oneSteps = 2; // number of one steps at the beginning
    int twoSteps = 1; // number of two steps at the beginning
    int allSteps = 0; // number of total steps at the beginning

    for(int i = 2; i < n; i++) {
      allSteps = oneSteps + twoSteps;
      twoSteps = oneSteps;
      oneSteps = allSteps;
    }

    return allSteps;
  }
}
