object SumTwoLargest {
  def main(args: Array[String]) {
    val input = List(10, 2, 3, 4, 0, 5, 15)
    
    println(sum(input, Integer.MIN_VALUE, Integer.MIN_VALUE))
  }
  
  def sum(input: List[Int], a: Int, b: Int): Int = {
    input match {
      case Nil => a + b
      case head :: tail => {
        if (a > b && head > b) {
          sum(tail, a, head)
        } else if (a <= b && head > a) {
          sum(tail, head, b)
        } else {
          sum(tail, a, b)
        }
      }
    }
  } 
}