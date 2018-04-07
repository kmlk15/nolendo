import scala.collection.mutable

/*
On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].

 */
object SwimInRisingWater {

  val directions = Array((1, 0), (-1, 0), (0, 1), (0, -1))

  def main(args: Array[String]): Unit = {
    println(check(Array(Array(0, 2), Array(1, 3))))
    println(check(Array(
      Array(0,1,2,3,4), Array(24,23,22,21,5),Array(12,13,14,15,16),Array(11,17,18,19,20),Array(10,9,8,7,6)
    )))
  }

  def check(input: Array[Array[Int]]): Int = {
    val fx = input.length - 1
    val fy = input(fx).length - 1
    val queue: mutable.Queue[(Int, Int)] = mutable.Queue((0, 0))
    val set: mutable.Set[String] = mutable.Set.empty
    var level: Int = 0
    var found = false

    while (!found) {
      while (queue.nonEmpty) {
        val (i, j) = queue.dequeue()

        if (!set.contains(s"$i-$j")) {
          directions.foreach { case (a ,b) => {
            val ni = i + a
            val nj = j + b
//            println(s"$level = $i $j ~ $a $b ~ $ni $nj")
            if (ni >= 0 && ni <= fx && nj >= 0 && nj <= fy && !set.contains(s"$ni-$nj") && input(ni)(nj) <= level) {
              if (ni == fx && nj == fy) {
                found = true
                queue.clear()
              } else queue.enqueue((ni, nj))
            }
          }}
          set.add(s"$i-$j")
        }
      }
      if (!found) {
        queue.enqueue((0, 0))
        level = level + 1
        set.clear()
      }
    }

    level

  }
}
