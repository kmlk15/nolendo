/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input:
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation:
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:
Input:
asteroids = [8, -8]
Output: []
Explanation:
The 8 and -8 collide exploding each other.
Example 3:
Input:
asteroids = [10, 2, -5]
Output: [10]
Explanation:
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
Example 4:
Input:
asteroids = [-2, -1, 1, 2]
Output: [-2, -1, 1, 2]
Explanation:
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.
Note:

The length of asteroids will be at most 10000.
Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */

object AsteroidCollision {

  def main(args: Array[String]): Unit = {
    println(check(List(5, 10, -5)))
    println(check(List(8, -8)))
    println(check(List(10, 2, -5)))
    println(check(List(-2, -1, 1, 2)))
  }

  def check(input: List[Int]): List[Int] = {
    var stack = List.empty[Int]

    input.foreach(item => {
      if (stack.isEmpty || stack.last < 0 || item > 0) stack = stack :+ item
      else {
        val abs = Math.abs(item)
        var end = false
        while (!end) {
          if (abs > stack.last) {
            stack = stack.dropRight(1)
            end = stack.isEmpty || stack.last < 0
          }
          else if (abs == stack.last) {
            stack = stack.dropRight(1)
            end = true
          } else {
            end = true
          }
        }
      }
    })

    stack
  }
}
