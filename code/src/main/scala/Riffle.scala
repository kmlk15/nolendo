

/**
 * @author kmlk15
 */
object Riffle {
  def main(args: Array[String]) {
    val input1 = List(1, 6, 7, 2, 8, 9, 3, 4, 5, 10)
    val input2 = List(1, 6, 7, 2, 8, 9, 3, 4, 5)
    val input3 = List(1, 3, 5, 7, 9, 2, 4, 6, 8, 10)
    val half1 = List(1, 2, 3, 4, 5)
    val half2 = List(6, 7, 8, 9, 10)
//    val input = Array(1d, 2d, 3d, 4d, 5d)

    println(check(input1, half1, half2))
    println(check(input2, half1, half2))
    println(check(input3, half1, half2))
  }

  def check(riffle: List[Int], half1: List[Int], half2: List[Int]): Boolean = {
    if (riffle.isEmpty && half1.isEmpty && half2.isEmpty) {
      true
    } else if (!riffle.isEmpty) {
      if (!half1.isEmpty && riffle.head == half1.head) {
        check(riffle.tail, half1.tail, half2)
      } else if (!half2.isEmpty && riffle.head == half2.head) {
        check(riffle.tail, half1, half2.tail)
      } else {
        false
      }
    } else false
  }

  
}