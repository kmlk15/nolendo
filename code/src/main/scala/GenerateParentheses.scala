

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
*/
object GenerateParentheses {
  def main(args: Array[String]) {
    
    println(generate(3).mkString("\n"))
    
  }
  
  def generate(i: Int): List[String] = {
    def g(a: Int, b: Int, current: String): List[String] = {
      if (b == 0) {
        List(current)
      } else if (a == b) {
        g(a - 1, b, current + "(")
      } else if (b > a && a > 0) {
        g(a - 1, b, current + "(") ++ g(a, b - 1, current + ")")
      } else {
        g(a, b - 1, current + ")")
      }
    }
    
    g(i, i, "")
  }
}