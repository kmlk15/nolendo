/*
N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.

 */
object CouplesHoldingHands {

  def main(args: Array[String]): Unit = {
    println(check(List(0, 2, 1, 3)))
    println(check(List(3, 2, 0, 1)))
    println(check(List(1, 2, 3, 4, 5, 0)))
  }

  def check(input: List[Int], count: Int = 0): Int = {
    input match {
      case Nil => count
      case a :: b :: tail =>
        val target = if (a % 2 == 1) a - 1 else a + 1
        if (b == target) check(tail, count)
        else {
          val (left, right) = tail.splitAt(tail.indexOf(target))
          check(left ++ List(b) ++ right.drop(1), count + 1)
        }
    }

  }
}
