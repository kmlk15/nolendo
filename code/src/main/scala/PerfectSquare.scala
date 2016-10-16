

/**
 * @author kmlk15
 */
object PerfectSquare {
  def main(args: Array[String]) {
    val sq = List(1, 4, 9, 16, 25, 36)
    val target = 12
    
    find(sq, target, 0)
    
    println(min)
  }
  
  var min = Integer.MAX_VALUE
  
  def find(input: List[Int], target: Int, count: Int) {
    if (input.length == 0 || target < 0) {
      return
    } else if (target == 0) {
      if (count < min) {
        min = count
      }
    } else {
      find(input, target - input.head, count + 1) 
      find(input.tail, target, count)
    }
  }
  
}