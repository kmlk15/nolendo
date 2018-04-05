import scala.collection.mutable

/*
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
object SlidingPuzzle {

  val finish = str(Array(Array(1, 2, 3), Array(4, 5, 0)))
  val directions = Array((1, 0), (-1, 0), (0, 1), (0, -1))

  def main(args: Array[String]): Unit = {
    println(check(Array(Array(1, 2, 3), Array(4, 0, 5))))
    println(check(Array(Array(1, 2, 3), Array(5, 4, 0))))
    println(check(Array(Array(4, 1, 2), Array(5, 0, 3))))
  }

  def check(
    input: Array[Array[Int]],
    queue: mutable.Queue[Array[Array[Int]]] = mutable.Queue.empty,
    set: Set[String] = Set.empty
  ): Boolean = {
    val (a, b) = find(input)
    directions.foreach { case (x, y) => {
      val nx = a + x
      val ny = b + y

      if (nx >= 0 && nx <= 1 && ny >= 0 && ny <= 2) {
        val t = input.map(_.clone)
        t(a)(b) = input(nx)(ny)
        t(nx)(ny) = t(a)(b)
        val tstr = str(t)
        if (tstr == finish) return true
        else if (!set.contains(tstr)) queue.enqueue(t)
      }
    }}

    if (queue.isEmpty) false
    else {
      val head = queue.dequeue
      check(head, queue, set + str(input))
    }
  }

  def find(input: Array[Array[Int]]): (Int, Int) = {
    for (i <- input.indices) {
      for (j <- input(i).indices) {
        if (input(i)(j) == 0) return (i, j)
      }
    }
    (0, 0)
  }

  def str(x: Array[Array[Int]]): String = {
    x.map(_.mkString("")).mkString("")
  }

}
