package Yangshun;

public class BestTimeToBuyAndSellStocks {

//  Say you have an array for which the ith element is the price of a given stock on day i.
//  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//  Note that you cannot sell a stock before you buy one.
//
//      Example 1:
//
//  Input: [7,1,5,3,6,4]
//  Output: 5
//  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//  Not 7-1 = 6, as selling price needs to be larger than buying price.


  public static int maxProfit(int[] prices) {
    int max = 0;
    int min = Integer.MAX_VALUE;

    // loop through all elements
    for(int i = 0; i < prices.length; i++) {
      // check if curr element is minimum
      if(prices[i] < min) {
        min = prices[i];
      } else {
        // calculate the max value
        max = Math.max(max, prices[i] - min);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};

    System.out.println(maxProfit(prices));
  }
}
