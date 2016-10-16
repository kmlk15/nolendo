object LargestContiguousSum {

  def main(args: Array[String]) {
    val input = List(-10, 2, 3, -2, 0, 5, -15)
    println(run(input, Integer.MIN_VALUE))
  }

  def run(input: List[Int], max: Int): Int = {
    input match {
      case Nil => max
      case head :: tail =>
        tail match {
          case Nil => max
          case _ => {
            if (head < tail.head && Math.abs(head + tail.head) > max) {
              run(tail, Math.abs(head + tail.head))
            } else {
              run(tail, max)
            }
          }
        }
    }
  }
}