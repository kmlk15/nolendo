/*
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
object BestTimeToBuyAndSellStockWithTransactionFee {

  def main(args: Array[String]): Unit = {
    println(check(List(1, 3, 2, 8, 4, 9), 2))
    println(check(List(1, 3, 2, 5, 8, 4, 2, 9), 2))
    println(check(List(1, 3, 2, 5, 8, 4, 2, 9), 1))
  }

  def check(prices: List[Int], fee: Int): Int = {
    var profit = 0
    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE

    prices.foreach(price => {
      if (min == Integer.MAX_VALUE || (max == Integer.MIN_VALUE && price < min)) {
        min = price
      } else if ((max == Integer.MIN_VALUE && price - min > fee) || (max != Integer.MIN_VALUE && price > max)) {
        max = price
      } else if (price < max) {
        profit = profit + max - min - fee
        min = price
        max = Integer.MIN_VALUE
      }
      // println(s"profit: $profit, price: $price, min: $min, max: $max")
    })
    if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
      profit = profit + max - min - fee
    }
    profit
  }
}
