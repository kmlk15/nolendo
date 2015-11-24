object ReverseString {

  def main(args: Array[String]) {
    val str = "asdfghjkl"
    
    println(reverse(str.split("").toList).mkString(""))
  }
  
  def reverse(i: List[String]): List[String] = {
    i match {
      case Nil => Nil
      case head :: tail => reverse(tail) :+ head
    }
  }
}