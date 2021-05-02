package Yangshun;

import java.util.Arrays;

public class CountPrimes {

  /*  https://leetcode.com/problems/count-primes/
  Count the number of prime numbers less than a non-negative number, n.

  Example 1:

  Input: n = 10
  Output: 4
  Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
   */

  public int countPrimes(int n) {
    boolean[] prime = new boolean[n];

    Arrays.fill(prime, true);

    // start at 2 since first prime is 2
    for(int i = 2; i * i < n; i++) { // no point in checking for numbers greater than n
      if(prime[i]) {
        for(int j = i; j * i < n; j++) {
          prime[i * j] = false;
        }
      }
    }

    int count = 0;
    for(int i = 2; i < n; i++) {
      if(prime[i]) {
        count++;
      }
    }

    return count;
  }
}
