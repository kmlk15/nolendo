/*
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.

*/

object LongestSubstringWithAtMostTwoDistinctCharacters {
  def main(args: Array[String]) {
    println(find("eceba"))
    println(find("annndddwweeeeewwweeasfee"))
  }

  def find(input: String): Int = {
    var max = 0    
    val arr = input.toCharArray
    var a = ""
    var b = ""
    var ac = 0
    var bc = 0
    var cc = 0

    for (i <- 0 until arr.length) {
      val c = arr(i).toString
      if (c == a) {
        a = b
        b = c        
        val t = ac
        ac = bc
        bc = t + 1
        cc = 1
      } else if (c == b) {
        bc = bc + 1
        cc = cc + 1
      } else {
        if (ac + bc > max) {
          max = ac + bc
        }
        a = b
        b = c
        ac = if (bc != cc) bc - cc else bc
        bc = 1
        cc = 1
      }  
      println(c + " : " + max + " : " + a + " " + ac + " ~ " + b + " " + bc + " ~ " + cc)
    }
    max
  }
}