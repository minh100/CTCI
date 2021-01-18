package Yangshun;

public class ContainerWithMostWater {

  /*
  Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
  n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
  Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

  Notice that you may not slant the container.

  Example 1:


  Input: height = [1,8,6,2,5,4,8,3,7]
  Output: 49
  Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
   */

  // use two pointers and work your way to the middle
  // essentially the steps are
  // 1. start at both ends with gives us the largest width
  // 2. check the water level from these two points
  // 3. check with height is less and move that accordingly
  public int maxArea(int[] height) {

    // pointers
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int highWater = 0;

    while (leftIndex < rightIndex) {
      // find max between current water level and recorded
      highWater = Math.max(
          highWater, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]) // formula gives width * the lesser height of the two pointers
      );
      if (height[leftIndex] > height[rightIndex]) { // if the right pointer is less than decrement it to move it
        rightIndex--;
      } else {                                      // else the left pointer is less than increment to move it
        leftIndex++;
      }
    }

    return highWater;
  }
}
