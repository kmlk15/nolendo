/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 */
object LongestIncreasingSubsequence {

  def main(args: Array[String]): Unit = {
    println(check(Array(10, 9, 2, 5, 3, 7, 101, 18)))
  }

  def check(input: Array[Int]): Int = {
    val dp = Array.fill[Int](input.length)(0)
    var res = 0
    input.zipWithIndex.foreach { case (v, i) => {
      for (j <- 0 until i) {
        println(s"v: $v, j: ${input(j)}, dpi: ${dp(i)}, dpj: ${dp(j)}")
        if (v > input(j)) dp(i) = Math.max(dp(i), dp(j) + 1)
      }
      println(dp.mkString(" "))
      res = Math.max(res, dp(i))
    }}

    res
  }
}
