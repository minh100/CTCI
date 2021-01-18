package Yangshun;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

  /*
  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

  Follow up: Could you implement the O(n) solution?

  Example 1:

  Input: nums = [100,4,200,1,3,2]
  Output: 4
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
   */

  // essentially add all element to a set to avoid duplicates
  // then you find the smallest element to start at and keep finding the next element in a sequence
  // then compare the current maxLength

  public int longestConsecutive(int[] nums) {
    // create set to avoid duplicates
    HashSet<Integer> set = new HashSet<>();
    for(int n : nums) {
      set.add(n);
    }

    int res = 0;  // return variable

    for(int n : set) {  // traverse all elements in set
      if(!set.contains(n - 1)) {  // look for element that is the smallest
        int nextElement = n + 1;  // find next element and keep looking for it
        while(set.contains(nextElement)) {
          nextElement++;
        }
        res = Math.max(res, nextElement - n); // compare lengths
      }
    }

    return res;
  }
}
