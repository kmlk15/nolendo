/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
object MaximumLengthOfRepeatedSubarray {

  def main(args: Array[String]): Unit = {
    println(check(List(1,2,3,2,1), List(3,2,1,4,7)))
  }

  def check(a: List[Int], b: List[Int]): Int = {
    val matrix = Array.fill[Int](a.length + 1, b.length + 1)(0)
    var result = 0
    a.zipWithIndex.foreach { case (av, ai) => {
      b.zipWithIndex.foreach { case (bv, bi) => {
        matrix(ai + 1)(bi + 1) = if (av == bv) matrix(ai)(bi) + 1 else 0
        result = Math.max(result, matrix(ai + 1)(bi + 1))
      }}
    }}
    result
  }
}
