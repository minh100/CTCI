package Yangshun;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

  /*
  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2]..]
  find the minimum number of conference rooms required

  Example 1:
  Input: [[0, 30], [5, 10], [15, 20]]
  Output: 2
   */

  public static int minMeetingRooms(int[][] intervals) {
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    for(int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);

    int res = 0;
    int current = 0;
    int j = 0;
    for(int i = 0; i < intervals.length; i++) {
      if(start[i] < end[j]) {
        current++;                  // need new meeting room
        res = Math.max(current,res);  // update res
      } else {
        current--;                  // a meeting room ended
        j++;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[][] array = {{0,30}, {5,10}, {15,20}};
    System.out.println(minMeetingRooms(array));
    int[][] arrayb = {{7,10},{2,4}};
    System.out.println(minMeetingRooms(arrayb));
  }
}
