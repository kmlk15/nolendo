

/**
 * @author kmlk15
 */
object Balloon {
  /*
  nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
  */
  def main(args: Array[String]) {
    val input = Array(3d, 1d, 5d, 8d)
//    val input = Array(1d, 2d, 3d, 4d, 5d)

    add2(input, 0)
    println(max)
  }

  var max = 0d

  def add2(input: Array[Double], current: Double) {
    if (input.length == 0) {
      if (current > max) 
        max = current
    } else {
      for (i <- input.toSeq.indices) {
        val (s, e) = input.splitAt(i)
        val n = if (e.length > 1) s ++ e.tail else s
        var c = input(i)
        if (i < input.length - 1) {
          c = c * input(i + 1)
        }
        if (i > 0) {
          c = c * input(i - 1)
        }
        add2(n, c + current)
      }
    }
  }
}