

/**
 * @author kmlk15
 */
object CountRangeSum {
  def main(args: Array[String]) {
    val input1 = List(-2, 5, -1) 
    val input2 = List(-2, 5, -1, -2) 
   
    println(count(input1.tail, -2, 2, input1.head, 0))
    println(count(input2.tail, -2, 2, input1.head, 0))
  }
  
  var map = Map.empty[Int, Int]
  
  def count(input: List[Int], l: Int, u: Int, cur: Int, index: Int): Int = {
//    println(input.mkString(",") + " " + cur )
    
    input match {
      case Nil => if (cur >= l && cur <= u) 1 else 0
      case head :: tail => 
        val t = if (map.contains(index) && head >= l && head <= u) {
          map = map + (index -> index)
          1
        } else 0
        t + count(tail, l, u, head + cur, index + 1) + count(tail, l, u, head, index + 1)
    }
    
  }
}