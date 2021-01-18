package Yangshun;

import java.util.Arrays;

public class SumOfWays {

  /*
    Given an int n find the number of possible ways to achieve n from 1 to k

    Example: n = 8, k = 2
    5 different ways
    [1,1,1,1,1,1,1,1]
    [1,1,1,1,1,1,2]
    [1,1,1,1,2,2]
    [1,1,2,2,2]
    [2,2,2,2]
   */

  public static void main(String[] args) {
    System.out.println(sumOfWays(8, 2));
  }

  public static int sumOfWays(int n, int k) {

    int ways = 1; // always one way
    int array[] = new int[n];

    Arrays.fill(array, 1);

    for(int i = 2; i <= k; i++) {
      int sum = 0;
      for(int j = 0; j < array.length; j++) {
        sum += array[j];
        if (sum + i == n) {
          ways++;
        }
      }
    }

    return ways;
  }

}
