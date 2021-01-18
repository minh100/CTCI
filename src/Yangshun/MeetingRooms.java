package Yangshun;

import java.util.Arrays;

public class MeetingRooms {

  /*
  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
  determine if a person can attend all meetings

  Example 1:
  Input: [[0,30],[5,10],[15,20]]
  Output: false
   */

  // simply put start and end times into separate arrays sort them and
  // check to see if the start times are greater than the end times then return false
  public static boolean canAttendMeetings(int[][] intervals) {
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];

    for(int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    Arrays.sort(start);
    Arrays.sort(end);

    for(int i = 0; i < start.length -1; i++) {
      if(start[i + 1] < end[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] array = {{0,30}, {5,10}, {15,20}};
    System.out.println(canAttendMeetings(array));
    int[][] arrayb = {{7,10},{2,4}};
    System.out.println(canAttendMeetings(arrayb));
  }


}
