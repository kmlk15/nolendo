/*
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.
For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

object StrobogrammaticNumber  {
  def main(args: Array[String]) {
    println(check("828"))
    println(check("69"))
    println(check("6 000 9"))
    println(check("818"))
    println(check("6699"))
    println(check("6969"))
  }
  
  def check(input: String): Boolean = {
    val arr = input.toCharArray
    var i = 0
    var j = arr.length-1
    var result = true
    
    while (i <= j) {
      if (!arr(i).equals(arr(j)) && 
          !((arr(i).equals('6') && arr(j).equals('9')) || (arr(i).equals('9') && arr(j).equals('6')))) {
        result = false
      } else if (arr(i).equals(arr(j)) && !arr(i).equals('0') && !arr(i).equals('1') && !arr(i).equals('8') && !arr(i).equals(' ')) {
        result = false
      }
      i = i + 1
      j = j - 1
    }
    result
  }
}