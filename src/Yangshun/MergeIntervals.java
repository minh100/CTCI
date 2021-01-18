package Yangshun;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

  /*
  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
  and return an array of the non-overlapping intervals that cover all the intervals in the input.

  Example 1:

  Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
  Output: [[1,6],[8,10],[15,18]]
  Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
   */


  public static int[][] merge(int[][] intervals) {
    // create two new arrays storing starting elements and ending elements
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    ArrayList<int[]> res = new ArrayList<>();

    // initialize start and end arrays
    for(int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0]; // we know the starting time is the first element and the end time is the second element
      end[i] = intervals[i][1];
    }

    // sort both arrays
    Arrays.sort(start);
    Arrays.sort(end);

    int startIdx = 0, endIdx = 0;

    while(endIdx < intervals.length) {
      if(endIdx == intervals.length - 1 || start[endIdx + 1] > end[endIdx]) {
        res.add(new int[]{start[startIdx], end[endIdx]});
        startIdx = endIdx + 1;
      }
      endIdx++;
    }

    return res.toArray(new int[res.size()][]);
  }

}
