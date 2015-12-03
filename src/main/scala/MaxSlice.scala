

/**
 * @author kmlk15
 */
object MaxSlice {
  def main(args: Array[String]) {
    val input = Array(-9, 1, 2, 4, 5, -10, 6, 9, 14, -8)  
    
    max_slice(input)
  }
  
  def max_slice(input: Array[Int]) {
    var curr = input
    var max = 0
    var nums = Array.empty[Int]
    var curMax = 0
    var curNums = Array.empty[Int]
    
    while (curr.length > 0) {
      for (i <- 0 until curr.length) {
        curMax = curMax + curr(i)
        curNums = curNums :+ curr(i)
        if (curMax > max) {
          max = curMax
          nums = curNums
        }
      }
      curMax = 0
      curNums = Array.empty[Int]
      curr = curr.tail
    }
    println(nums.mkString(" ") + " ~ " + max)
  }
  
}