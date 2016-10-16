/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

object GeneralizedAbbreviation {
  def main(args: Array[String]) {
    println(build("word").mkString(" "))
  }
  
  def build(input: String): List[String] = {
    var result = List(input)
    
    for (i <- 1 to input.length) {
      for (j <- 0 to input.length - i) {
        val tmp = if (j+i <= input.length) {
            input.substring(0, j) + (i).toString + input.substring(j+i)
          } else {
            input.substring(0, j) + (i).toString
          }
        println(i + " " + j + " : " + tmp)
        result = result :+ tmp       
      }
    }
    
    result
  }
}