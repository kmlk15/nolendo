/*
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
object MaxChunksToMakeSorted {

  def main(args: Array[String]): Unit = {
    println(check(List(4, 3, 2, 1, 0)))
    println(check(List(1, 0, 2, 3, 4)))
    println(check(List(2, 1, 3, 4, 4)))
  }

  def check(input: List[Int]): Int = {
    val sorted = input.sorted

    val initial = input.map(a => List(a))
    var max = 1

    for (i <- 0 until initial.length - 1) {
      for (j <- i + 1 until initial.length) {
        val start = initial.take(i)
        val moving = initial.slice(i, i + j)
        val end = initial.drop(i + j)
        val result = start.flatten ++ moving.flatten.sorted ++ end.flatten
        if (result == sorted) max = Math.max(max, start.length + 1 + end.length)
      }
    }
    max
  }
}
