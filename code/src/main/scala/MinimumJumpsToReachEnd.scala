import scala.collection.mutable

/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
 */

object MinimumJumpsToReachEnd {

  def main(args: Array[String]): Unit = {
    println(check(List(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
    println(check(List(1, 3, 6, 3, 2, 3, 6, 8, 9, 5)))
    println(check(List(1, 3, 6, 1, 0, 9)))
  }

  def check(input: List[Int]): Int = {
    var step = 1
    var start = input.head
    var rest = input.tail
    var found = false
    if (start == 0) return -1
    while (!found) {
      step = step + 1
      val (move, index) = rest.take(start).zipWithIndex.maxBy(_._1)
//      println(s"S: $step, T: $start, M: $move, I: ${index + 1}")
      if (move >= rest.length) {
        found = true
      } else {
        start = move
        rest = rest.drop(index + 1)
      }
    }
    step
  }
}
