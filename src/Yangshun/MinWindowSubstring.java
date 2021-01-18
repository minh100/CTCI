package Yangshun;

public class MinWindowSubstring {

  /*
  Given two strings s and t, return the minimum window in s which will contain all the characters in t.
  If there is no such window in s that covers all characters in t, return the empty string "".

  Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

  Example 1:

  Input: s = "ADOBECODEBANC", t = "ABC"
  Output: "BANC"
   */

  // sliding window solution
  // leetcode hard
  // two pointers used to essentially track if the current pointers satisfy the conditions of t
  public String minWindow(String s, String t) {

    int[] map = new int[128]; // 128 ascii characters

    // account for only the important elements in t
    for(char c: t.toCharArray()) {
      map[c]++;
    }

    int start = 0;  // starting pointer
    int end = 0;    // end pointers
    int minstart = 0; // records the starting point for min substring
    int minLen = Integer.MAX_VALUE; // records min length
    int counter = t.length();

    // starting pointer and move the end pointers until the window doesn't satisfy the conditions then move the start pointer
    while(end < s.length()) {
      char c1 = s.charAt(end);
      if(map[c1] > 0) {
        counter--;
      }
      map[c1]--;
      end++;

      while(counter == 0) {
        if(minLen > end - start) {  // determines if we found a smaller window
          minLen = end - start;
          minstart = start;
        }

        char c2 = s.charAt(start);
        map[c2]++;
        if(map[c2] > 0) {
          counter++;
        }
        start++;  // increment the starting pointer to look for new windows
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minstart, minstart + minLen);
  }
}
