/*
Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

 */
object DailyTemperatures {

  def main(args: Array[String]): Unit = {
    println(check(Array(73, 74, 75, 71, 69, 72, 76, 73)).mkString(" "))
  }

  def check(input: Array[Int]): Array[Int] = {
    var stack = List.empty[Int]
    val output = Array.ofDim[Int](input.length)

    input.zipWithIndex.foreach { case (v, i) =>
      while (stack.nonEmpty && v > input(stack.last)) {
        val cur = stack.last
        output(cur) = i - cur
        stack = stack.dropRight(1)
      }
      stack = stack :+ i
    }
    output
  }
}
