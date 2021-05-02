package Yangshun;

import java.util.Arrays;

public class DuplicateZeros {

  /*
  Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
  Note that elements beyond the length of the original array are not written.
  Do the above modifications to the input array in place, do not return anything from your function.

  Example 1:

  Input: [1,0,2,3,0,4,5,0]
  Output: null
  Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
   */

  // use two pointers to shift the elements to the right
  // start at the end of the array
  public static void duplicateZeros(int[] array) {
    int zeroCount = 0;  // count the amount of space minimum needed to shift
    for(int x: array) {
      if(x == 0) zeroCount++;
    }

    int len = array.length + zeroCount; // second pointer start index
    // i is the first pointer where we check to see if the array is 0 if so we
    // check to see if the second pointer is at a valid index and then we assign the first pointer's
    // element to the second pointers index
    for(int i = array.length - 1, j = len - 1; j > i; j--, i--) {
      if (array[i] != 0) {
        if (j < array.length)
          array[j] = array[i];
      } else {
        if (j < array.length)
          array[j] = array[i];
        j--;
        if (j < array.length)
          array[j] = array[i];
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1,0,2,3,0,4,5,0};
    duplicateZeros(a);
    System.out.println(Arrays.toString(a));
  }
}
