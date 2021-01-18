package Yangshun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFreqElement {

  /*
  Given a non-empty array of integers, return the k most frequent elements.

  Example 1:

  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
   */

  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();  // map used to count the freq
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] bucket = new List[nums.length + 1];
    for (int n : map.keySet()) {
      int count = map.get(n);
      if (bucket[count] == null) {
        bucket[count] = new ArrayList<>();
      }
      bucket[count].add(n);
    }

    int[] res = new int[k];

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
