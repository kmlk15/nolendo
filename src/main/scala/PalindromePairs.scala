

/**
 * @author kmlk15
 */
object PalindromePairs {

  def main(args: Array[String]) {
    val words1 = List("bat", "tab", "cat")
    val words2 = List("abcd", "dcba", "lls", "s", "sssll")
    
    println(check(words1, 0, List.empty[(Int, Int)]).mkString(" "))
    println(check(words2, 0, List.empty[(Int, Int)]).mkString(" "))
  }

  def check(input: List[String], index: Int, cur: List[(Int, Int)]): List[(Int, Int)] = {
    input match {
      case Nil => cur
      case head :: tail =>
        var tmp = List.empty[(Int, Int)]
        tail.zipWithIndex.foreach(item => {
          val (v, i) = item
          if (isPalindrome(head + v)) {
            tmp = tmp :+ (index, index + i + 1)
          }
          if (isPalindrome(v + head)) {
            tmp = tmp :+ (index + i + 1, index)
          }
        })
        check(tail, index + 1, cur ++ tmp)
    }
  }

  def isPalindrome(s: String): Boolean = {
    s == s.reverse
  }
}