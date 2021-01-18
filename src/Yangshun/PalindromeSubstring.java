package Yangshun;

public class PalindromeSubstring {

  /*
  Given a string, your task is to count how many palindromic substrings in this string.

  The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

  Example 1:

  Input: "abc"
  Output: 3
  Explanation: Three palindromic strings: "a", "b", "c".
   */

  // solve this by using two pointers starting from one single index and going both left and right to check if palindrome
  // the trick in this question is that you can do substring on this which makes it more tricky
  public static int countSubstrings(String s) {
    int count = 0;
    for(int i = 0; i < s.length(); i++) { // start at each element and traverse left and right checking if palindrome
      count += extractPalindrome(s, i, i);  // odd length
      count += extractPalindrome(s, i, i + 1);  // even length
    }
    return count;
  }

  // helper function that does the traversing
  public static int extractPalindrome(String s, int left, int right) {
    int count = 0;
    while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
      left--;
      right++;
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    String s = "abc";
    System.out.println(countSubstrings(s));
  }
}
