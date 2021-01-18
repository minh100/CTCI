package Yangshun;

import java.util.HashMap;

public class ValidAnagram {

//  Given two strings s and t , write a function to determine if t is an anagram of s.
//
//  Example 1:
//
//  Input: s = "anagram", t = "nagaram"
//  Output: true

  public static boolean isAnagram(String s, String t) {

    if(s.length() != t.length()) {
      return false;
    }

    int[] array = new int[26];

    for(Character c: s.toCharArray()) {
      int index = c - 'a';
      array[index]++;
    }
    for(Character h: t.toCharArray()) {
      int index = h - 'a';
      array[index]--;
    }
    for(int a : array) {
      if(a != 0) {
        return false;
      }
    }

    return true;

  }

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram", "nagaram"));
    System.out.println(isAnagram("rat", "car"));
    System.out.println(isAnagram("aa","bb"));
  }
}
