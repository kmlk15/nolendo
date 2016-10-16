object CoinChange {
  def main(args: Array[String]) {
    println(check(4, List(1, 2)))
  }

  def check(amount: Int, change: List[Int]): Int = {
    change match {
      case Nil => 0
      case _ => {
        amount match {
          case i if i == 0 => 1
          case i if i < 0 => 0
          case _ => check(amount - change.head, change) + check(amount, change.tail)
        }
      }
    }
  }
}