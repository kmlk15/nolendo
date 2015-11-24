object Fibonacci {
  
  def main(args: Array[String]) {
    val max = 100
    
    println(run(1, 1, max))
  }
  
  def run(x: Int, y: Int, limit: Int): List[Int] = {
    x match { 
      case a if a > limit => Nil
      case _ => x :: run(y, x + y, limit) 
    }
  } 
}