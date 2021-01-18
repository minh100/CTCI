package Yangshun;

public class UniquePaths {

  /*
  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

  The robot can only move either down or right at any point in time.
  The robot is trying to reach the bottom-right corner of the grid
  (marked 'Finish' in the diagram below).

  How many possible unique paths are there?

  Example 2:

  Input: m = 3, n = 2
  Output: 3
  Explanation:
  From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
  1. Right -> Down -> Down
  2. Down -> Down -> Right
  3. Down -> Right -> Down
   */

  public int uniquePaths(int m, int n) {
    // edge cases
    if(m == 0 || n == 0) return 0;
    if(m == 1 || n == 1) return 1;  // only one path give one space

    int[][] dp = new int[m][n];

    for(int i = 0; i < m; i++) {  // path going straight down is only 1
      dp[i][0] = 1;
    }

    for(int i = 0; i < n; i++) {  // path going straight right is only 1
      dp[0][i] = 1;
    }

    // start at index 1,1 since we got the paths for straight right and straight down
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        dp[i][j] = dp[i][j -1] + dp[i -1][j]; // the path to get to this index is the sum of the left and right index paths
      }
    }

    return dp[m - 1][n - 1];
  }
}
