package Yangshun;

import java.util.HashSet;

public class ContainsDuplicate {

//  Given an array of integers, find if the array contains any duplicates.
//  Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

//  Example 1:
//
//  Input: [1,2,3,1]
//  Output: true

  static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for(int i : nums) {
      if(set.contains(i)) {
        return true;
      }
      set.add(i);
    }

    return false;
  }

  public static void main(String[] args) {
    int nums[] = {1,2,3,1};
    int numsA[] = {1,2,3,4};
    System.out.println(containsDuplicate(nums));
    System.out.println(containsDuplicate(numsA));
  }
}
