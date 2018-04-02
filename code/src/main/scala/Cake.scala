

/**
 * @author kmlk15
 */
object Cake {
  //  cake_tuples = [(7, 160), (3, 90), (2, 15)]
  //  capacity    = 20

  var value = 0

  def main(args: Array[String]) {
    val input = List((7, 160), (3, 90), (2, 15))
    val cap = 20
    
    max(input, cap, 0)
    
    println(value)
  }

  def max(input: List[(Int, Int)], cap: Int, cur: Int) {
    if (cap < 0 || input.isEmpty) {
      return
    }
    if (cur > value) {
      value = cur
    }     
    max(input, cap - input.head._1, cur + input.head._2)
    max(input.tail, cap, cur)
  }
}