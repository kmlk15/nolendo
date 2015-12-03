

/**
 * @author kmlk15
 */
object LongestValidParentheses {
  def main(args: Array[String]) {
    println(check("(()"))
    println(check(")()())"))
    println(check("(())()())"))
  }
  
  def check(str: String): Int = {
    var max = 0
    var cur = 0
    var counter = 0
    val input = str.toArray
    
    for (i <- 0 until input.length) {
      if (input(i) == '(') {
        counter += 1 
        cur += 1
      } else if (input(i) == ')') {
        counter -= 1
        cur += 1
        if (counter == 0 && cur > max) { 
            max = cur
        } else if (counter < 0) {
          cur = 0
          counter = 0
        } else if (counter > 0 && cur - counter > max) {
          max = cur - counter
        }
      }
    }
    
    max
  }
}