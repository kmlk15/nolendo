/*
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].
 */
object MonotoneIncreasingDigits {

  def main(args: Array[String]): Unit = {
    println(check("10"))
    println(check("1234"))
    println(check("332"))
    println(check("232"))
    println(check("999"))
  }

  def check(input: String, cur: String = "", output: String = ""): String = {
    if (input.isEmpty) cur + output
    else if (cur.isEmpty) {
      check(input.dropRight(1), input.last.toString, output)
    } else {
      val e = input.last.toString
      if (e <= cur) {
        check(input.dropRight(1), e, cur + output)
      } else {
        val n = e.toInt - 1
        val r = if (n <= 0) "" else n.toString
        input.dropRight(1) + r + output.split("").map(_ => "9").mkString("")
      }

    }
  }
}
