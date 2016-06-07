/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
 */

object ContainerWithMostWater {
  def main(args: Array[String]) {
    val input = Array(5, 8, 3, 9, 7, 3, 5, 4)  
    
    println(find(input))
  }
  
  def find(input: Array[Int]): (Int, Int) = {
    var a = 0
    var b = 0
    var max = 0
    
    for (i <- 0 until input.size - 1) {
      val c = Math.min(input(i), input(i+1))
      if (c > max) {
        a = input(i)
        b = input(i+1)
        max = c
      }
    }
    
    (a, b)
  }
}