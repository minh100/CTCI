package Yangshun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

  /*
  Given an array of strings strs, group the anagrams together. You can return the answer in any order.

  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

  Example 1:

  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
   */

  public static List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> groupedAnagrams = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    // sort the characters of a word to see if any other words matches if so add it to the array if not create new array
    for(String current: strs) {
      char[] character = current.toCharArray(); // gets char array
      Arrays.sort(character);                   // sorts the char array
      String sorted = new String(character);    // string of the sorted char array

      if(!map.containsKey(sorted)) {            // if map doesn't contains the sorted string then create new array
        map.put(sorted, new ArrayList<>());
      }

      map.get(sorted).add(current);             // add the original word to map
    }

    groupedAnagrams.addAll(map.values());       // add all map values to double List
    return groupedAnagrams;
  }
}
