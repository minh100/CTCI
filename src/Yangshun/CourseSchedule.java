package Yangshun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

  /*
  There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

  Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

  Example 1:

  Input: numCourses = 2, prerequisites = [[1,0]]
  Output: true
  Explanation: There are a total of 2 courses to take.
               To take course 1 you should have finished course 0. So it is possible.
   */

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] adjacent = new List[numCourses];
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adjacent[i] = new ArrayList<>();
    }

    for (int[] req : prerequisites) {
      adjacent[req[1]].add(req[0]);
      indegree[req[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      count++;
      for (int courses : adjacent[queue.poll()]) {
        if (--indegree[courses] == 0) {
          queue.offer(courses);
        }
      }
    }
    return count == numCourses;

  }
}
