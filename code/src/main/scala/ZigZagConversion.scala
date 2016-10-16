/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */
object ZigZagConversion {
  def main(args: Array[String]) {
    val input = "PAYPALISHIRING".toCharArray()
    
    println(convert(input, 3))
  }
  
  def convert(input: Array[Char], row: Int): String = {
    var result = List.empty[Char]
    val step = row + 1
    
    for (i <- 0 until row) {
      val step = if (i % 2 == 0) {
        row + 1
      } else {
        row - 1
      }
      var cur = i
      var now = List.empty[Char]
      while (cur < input.size) {
        now = now :+ input(cur)
        cur = cur + step
      }
      if (i % 2 == 0) {
        println(now.mkString("   "))
      } else {
        println(now.mkString(" "))
      }
      result = result ++ now
    }
    
    result.mkString("")
  }
  
  
}