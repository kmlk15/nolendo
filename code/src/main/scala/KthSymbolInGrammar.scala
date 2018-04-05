/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].

 */
object KthSymbolInGrammar {

  def main(args: Array[String]): Unit = {
    println(check(1, 1))
    println(check(2, 1))
    println(check(2, 2))
    println(check(4, 5))
  }

  def check(n: Int, k: Int): Int = {
    val arr = Array.fill[Int](n + 1, n * 2)(0)
    arr(0)(0) = 0
    arr(1)(0) = 0
    arr(1)(1) = 1

    for (i <- 1 until n) {
      for (j <- 0 to i) {
        val (a, b) = get(arr(i)(j))
        arr(i + 1)(j * 2) = a
        arr(i + 1)(j * 2 + 1) = b
      }
    }
//    arr.foreach(a => println(a.mkString(" ")))
    arr(n - 1)(k - 1)
  }

  def get(i: Int): (Int, Int) = {
    if (i == 0) (0, 1)
    else (1, 0)
  }
}
