package Yangshun;

import java.util.HashMap;

public class TwoSum {

//  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.
//  You can return the answer in any order.

  static int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      if (map.containsKey(target - val)) {
        res[0] = i;
        res[1] = map.get(target - val);
        return res;
      }
      map.put(val, i);

    }

    return res;

  }

  public static void main(String[] args) {
    int nums[] = {2, 7, 11, 15};
    int target = 17;

    System.out.println(twoSum(nums, target)[0]);
    System.out.println(twoSum(nums, target)[1]);
  }
}
