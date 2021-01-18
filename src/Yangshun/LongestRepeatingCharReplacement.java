package Yangshun;

public class LongestRepeatingCharReplacement {

  /*
  Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
  In one operation, you can choose any character of the string and change it to any other uppercase English character.
  Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

  Note:
  Both the string's length and k will not exceed 104.

  Example 1:

  Input:
  s = "ABAB", k = 2

  Output:
  4

  Explanation:
  Replace the two 'A's with two 'B's or vice versa.
   */

  // sliding window solution
  public static int characterReplacement(String s, int k) {
    int count[] = new int[26];  // array of char
    int start = 0;              // starting index
    int maxCount = 0;           // largest count of a single, unique char
    int maxLength = 0;          // largest length of a substring


    for(int end = 0; end < s.length(); end++) {
      count[s.charAt(end) - 'A']++;
      maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

      // this equation gives the char in the window that are NOT the char that occurs the most
      // important to determine if the letters to change is possible to create a continuous long string
      if(end - start + 1 - maxCount > k) {
        count[s.charAt(start) - 'A']--;
        start++;      // shift window to right by one
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(characterReplacement("AABABBA",1));
  }
}
