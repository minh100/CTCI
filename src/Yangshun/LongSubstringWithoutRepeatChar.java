package Yangshun;

public class LongSubstringWithoutRepeatChar {

  /*
  Given a string s, find the length of the longest substring without repeating characters.

  Example 1:

  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.
   */

  // utilizes a sliding window solution
  // using two pointers and an array to keep track of repeats


  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    int[] count = new int[256];

    for(int i = 0, j = 0; i < s.length(); i++) {
      j = count[s.charAt(i)] > 0 ? Math.max(j, count[s.charAt(i)]) : j; // counts the number
      count[s.charAt(i)] = i + 1;
      res = Math.max(res, i - j + 1);
    }

    return res;

  }
}
