package Yangshun;

public class WaysToReachScore {

  // Java program to count number of
  // possible ways to a given score
  // can be reached in a game where
  // a move can earn 3 or 5 or 10
  public static void main(String[] args) {
    System.out.println(waysToReach(20));
  }

  private static int waysToReach(int n) {

    int dp[] = new int[n + 1];  // dp array size n + 1

    dp[0] = 1;                  // base case

    // these can be replaced with any number
    for (int i = 3; i <= n; i++) {  //  move where you can earn 3 points
      dp[i] += dp[i - 3];
    }
    for (int j = 5; j <= n; j++) {  // move where you can earn 5 points
      dp[j] += dp[j - 5];
    }
    for (int k = 10; k <= n; k++) { // move where you can earn 10 points
      dp[k] += dp[k - 10];
    }

    return dp[n]; // resulting answer
  }
}
