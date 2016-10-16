

/**
 * @author kmlk15
 */
object ThreeSum {
  /*
  given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
  */
  def main(args: Array[String]) {
    val input = Array(-1, 0, 1, 2, -1, -4)
    
    sum(input).foreach(i => println(i.mkString(" ")))
  }
  
  def sum(input: Array[Int]): List[List[Int]] = {
    var result = Set.empty[List[Int]]
    
    for (i <- 0 until input.length) {
      for (j <- i+1 until input.length) {
        for (k <- j+1 until input.length) {
          if (input(i) + input(j) + input(k) == 0) {
            val t =  List(input(i), input(j), input(k)).sortWith(_ < _)
            result = result + t
          }
        }
      }
    }
    
    result.toList
  }
}