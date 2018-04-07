/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 */
object ReorganizeString {

  def main(args: Array[String]): Unit = {
    println(check(Array("a", "a", "b")))
    println(check(Array("a", "a", "a", "b")))
  }

  def check(input: Array[String]): String = {
    for (i <- input.indices) {
      for (j <- i + 1 until input.length) {
        val current = input.clone()
        val tmp = current(i)
        current(i) = current(j)
        current(j) = tmp
        var good = true
        for (x <- 0 until current.length - 1 if good) {
          if (current(x) == current(x + 1)) good = false
        }
        if (good) return current.mkString("")
      }
    }
    ""

  }
}
