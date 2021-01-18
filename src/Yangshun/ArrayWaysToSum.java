package Yangshun;

public class ArrayWaysToSum {

  /*
  Given a set of m distinct positive integers and a value ‘N’.
  The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements.
  Repetitions and different arrangements are allowed.

  Examples :

  Input : arr = {1, 5, 6}, N = 7
  Output : 6

  Explanation:- The different ways are:
  1+1+1+1+1+1+1
  1+1+5
  1+5+1
  5+1+1
  1+6
  6+1
   */

  public static int countWays(int[] array, int k) {
    int dp[] = new int[k + 1];

    dp[0] = 1;

    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i >= array[j]) {
          dp[i] += dp[i - array[j]];
        }
      }
    }

    return dp[k];
  }

  public static void main(String[] args) {

    int[] a = {1, 2,3,4};
    int k = 3;

    int[] b = {1,5,6};
    int n = 7;

    System.out.println(countWays(a, k));
    System.out.println(countWays(b, n));
  }


}
