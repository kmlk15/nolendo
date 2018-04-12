/*
You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].

 */
object ReachANumber {

  def main(args: Array[String]): Unit = {
//    println(check(3))
//    println(check(2))
    println(check(4))
  }

  def check(t: Int): Int = {
    var i = 0
    var c = 0

    while (i != t) {
      c = c + 1
      if (i + c <= t) {
        i = i + c
      } else {
        i = i - c
      }
    }
    c
  }
}
