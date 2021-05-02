package Yangshun;

public class IntegerToEnglish {

  /*  https://leetcode.com/problems/integer-to-english-words/
  Convert a non-negative integer num to its English words representation.

  Example 1:

  Input: num = 123
  Output: "One Hundred Twenty Three"
  Example 2:

  Input: num = 12345
  Output: "Twelve Thousand Three Hundred Forty Five"
   */

  // arrays of possible english numbers
  private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"};
  private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
  private static final String[] THOUSANDS = {"","Thousand","Million","Billion"};

  public static String numberToWords(int num) {
    // edge cases
    if(num == 0) return "Zero";

    int i = 0;
    String words = "";

    while(num > 0) {
      if(num % 1000 != 0) {
        words = helper(num % 1000) + THOUSANDS[i] + " " + words;
      }
      num /= 1000;
      i++;
    }

    return words.trim();
  }

  public static String helper(int num) {
    if(num == 0) return "";
    else if(num < 20) return LESS_THAN_20[num] + " ";
    else if(num < 100) return TENS[num / 10] + " " + helper(num % 10);
    else {
      return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
  }

  public static void main(String[] args) {
    System.out.println(numberToWords(123));
//    System.out.println(numberToWords(1234));
    System.out.println(numberToWords(12345));
//    System.out.println(numberToWords(1234567));
    System.out.println(12345 % 1000);
    System.out.println(345 / 100);
    System.out.println(345 % 100);
    System.out.println(45 / 100);

  }
}
