/*
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

    For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

    Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

    Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

object ShortestWordDistance {
  def main(args: Array[String]) {
    val input = List("practice", "makes", "perfect", "coding", "makes")
    println(find(input, "coding", "practice"))
    println(find(input, "coding", "makes"))
    println(find(input, "makes", "makes"))
  }

  def find(words: List[String], a: String, b: String): Int = {
    var result = Integer.MAX_VALUE
    var n = 0
    var cur = ""

    for (i <- 0 until words.length) {
      if (cur != "") n = n + 1
      if ((words(i) == a && cur == b) || (words(i) == b && cur == a)) {
        if (result > n) {
          result = n
          n = 0
        }
        cur = words(i)
      } else if (words(i) == a || words(i) == b) {
        cur = words(i)
      }
    }

    result
  }
}