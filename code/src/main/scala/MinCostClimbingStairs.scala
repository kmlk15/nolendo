/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
object MinCostClimbingStairs {

  def main(args: Array[String]): Unit = {
    println(check(List(10, 15, 20)))
    println(check(List(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
  }

  def check(input: List[Int]): Int = {
    var cost = 0
    var found = false
    var cur = input

    while (!found) {
      if (cur.length == 3) {
        if (cur(0) + cur(2) > cur(1)) {
          cost = cost + cur(1)
          found = true
        }
      }
      if (!found) {
        val a = cur(0)
        val b = cur(1)
        if (a >= b) {
          cur = cur.drop(2)
          cost = cost + b
        } else {
          cur = cur.drop(1)
          cost = cost + a
        }
      }
      if (cur.length < 2) found = true
    }

    cost
  }
}
