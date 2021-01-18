package Yangshun;

public class BinarySearch {

  // Binary Search on an array
  // Recursive Solution logN
  static int binSearch(int[] a, int key) {
    return helper(a, key, 0, a.length - 1);
  }

  static int helper(int[] a, int key, int start, int end) {

    if(start > end) {
      return -1;
    }


//    int mid = start + ((end- start) / 2);
    int mid = (start + end) / 2;

    if(a[mid] == key) {
      return mid;
    }
    else if (a[mid] > key) {  // mid val is greater than key means key is located below
      return helper(a, key, start, mid - 1);
    }
    else if (a[mid] < key) {  // mid val is less than key means key is located above
      return helper(a, key, mid + 1, end);
    }

    else {
      return -1;
    }
  }

  // Iterative Solution logN
  static int binSearchItr(int[] a, int key) {
    int left = 0;
    int right = a.length - 1;
    int index = -1;

    if(a.length == 1) {
      return 0;
    }

    while(left <= right) {
//      int mid = left + ((right - left) / 2);
      int mid = (left + right) / 2;
      if(a[mid] == key) {
        index = mid;
        return index;
      }
      else if (a[mid] > key) {
        right = mid - 1;
      }
      else if (a[mid] < key) {
        left = mid + 1;
      }
    }

    return index;


  }

  public static void main(String[] args) {
    int[] array = {1, 2,3,4,5,6};
    int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
    int[] inputs = {10, 49, 99, 110, 176};

    System.out.println(binSearch(array, 3));
    System.out.println(binSearch(arr, 120));
    System.out.println(binSearch(inputs, 176));

    System.out.println(binSearchItr(array, 3));
    System.out.println(binSearchItr(arr, 120));
    System.out.println(binSearchItr(inputs, 176));
  }
}
