

/**
 * @author kmlk15
 */
object WordBreak {
  def main(args: Array[String]) {
    val s = "catsanddog"
    val dict = List("cat", "cats", "and", "sand", "dog")
    
    println(write(s, dict, List.empty[String]).mkString("\n"))
  }
  
  def write(input: String, dict: List[String], current: List[String]): List[String] = {
    val tmp = current.mkString("")
    if (input.length == tmp.length && input.startsWith(tmp)) {
      List(current.mkString(" "))
    } else if (!input.startsWith(tmp) || dict.length == 0) {
      List.empty[String]
    } else {
      write(input, dict.tail, current) ++ write(input, dict.tail, current :+ dict.head)
    }
    
  }
}