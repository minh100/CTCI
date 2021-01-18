package Yangshun;

public class NumberOfIslands {

  /*
  Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
  You may assume all four edges of the grid are all surrounded by water.

  Example 1:

  Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
  Output: 1
   */

  // traverse the entire array
  // for each '1' value we flip the value to '0' and visit the neighboring '1' to avoid counting the same island as multiples
  public int numIslands(char[][] grid) {
    // edge cases
    if(grid == null || grid.length == 0) {
      return 0;
    }

    int res = 0;

    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        if(grid[i][j] == '1') {
          res += helper(grid, i, j);
        }
      }
    }

    return res;
  }

  public int helper(char[][] grid, int i, int j) {
    // edge cases
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
      return 0;
    }

    grid[i][j] = '0';         // flips the current island

    // recursively look at adjacent islands and flip them all
    helper(grid, i + 1, j);
    helper(grid, i - 1, j);
    helper(grid, i, j + 1);
    helper(grid, i, j - 1);

    return 1; // return 1 since we are only accounting for one island

  }
}
