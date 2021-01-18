package Yangshun;

import java.util.ArrayList;

public class InsertInterval {

  /*
  Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

  You may assume that the intervals were initially sorted according to their start times.

  Example 1:

  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  Output: [[1,5],[6,9]]
   */

  public int[][] insert(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> res = new ArrayList<>(); // return variable
    int i = 0;
    // add all the intervals ending before newInterval starts
    while(i < intervals.length && intervals[i][1] < newInterval[0]) {
      res.add(intervals[i++]);
    }

    // merge all overlapping intervals to one considering newInterval
    while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    res.add(newInterval);

    // add the rest of the intervals
    while(i < intervals.length) {
      res.add(intervals[i++]);
    }

    return res.toArray(new int[res.size()][]);
  }
}
