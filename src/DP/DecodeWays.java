package DP;

public class DecodeWays {

  /*
   message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.



Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
   */


  public static int numDecodings(String s) {

    int[] dp = new int[s.length() + 1]; // why "+1"? is due to the fact there is always one way to decode something

    dp[0] = 1; // only one way to decode with one digit
    dp[1] = s.charAt(0) == '0' ? 0 : 1; // no way to decode 0

    // starts at 2 because we solved for index 0 and 1
    for (int i = 2; i <= s.length(); i++) {

      // gets one digit at specific index of string
      int oneDigit = Integer.valueOf(s.substring(i - 1, i));

      // gets two digits at specific index of string
      int twoDigit = Integer.valueOf(s.substring(i - 2, i));

      // checks to see if digit is within bounds of ones place
      if (oneDigit >= 1 && oneDigit <= 9) {
        dp[i] += dp[i - 1];
      }

      // checks to see if digit is within bounds till 'z'
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()]; //by using dp the answer is at last index
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("12"));
    System.out.println(numDecodings("226"));
  }

}
