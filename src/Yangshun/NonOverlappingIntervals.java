package Yangshun;

import java.util.Arrays;

public class NonOverlappingIntervals {

  /*
  Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

  Example 1:

  Input: [[1,2],[2,3],[3,4],[1,3]]
  Output: 1
  Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
   */

  public static int eraseOverlapIntervals(int[][] intervals) {

    if(intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);  // sort by end times

    int end = intervals[0][1];
    int count = 1;
    for(int i = 1; i < intervals.length; i++) {
      if(intervals[i][0] >= end) {
        end = intervals[i][1];
        count++;
      }
    }

    return intervals.length - count;  // {all intervals} - {max compatible intervals} = minimum deleted intervals
  }

  public static void main(String[] args) {
    int[][] array = {{1,2},{2,3},{3,4},{1,3}};

    System.out.println(eraseOverlapIntervals(array));
  }
}
