package Yangshun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElement {

  /*  https://leetcode.com/problems/top-k-frequent-elements/
  Given a non-empty array of integers, return the k most frequent elements.

  Example 1:

  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
   */

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();  // map used to count the freq

    for (int num : nums) {  // populate the map
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] bucket = new List[nums.length + 1]; // used to arrange all values with same amount of count

    for (int n : map.keySet()) {  // populate the bucket List
      int count = map.get(n); // gets the count value of the key as the index
      // if the index is null that means we have not yet encountered that count
      // at that index create a new list
      if (bucket[count] == null) bucket[count] = new ArrayList<>();

      bucket[count].add(n); // add the elements with the same count in the same list
    }

    int[] res = new int[k]; // return variable

    int index = 0;
    for (int i = bucket.length - 1; i >= 0; i--) {
      if (bucket[i] != null) {
        for (int n : bucket[i]) {
          res[index++] = n;
          if (index == k) {
            return res;
          }
        }
      }
    }

    return res;
  }
}
