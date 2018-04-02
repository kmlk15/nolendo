import scala.collection.mutable.Stack

object Braces {
  def main(args: Array[String]) {
    val input1 = "{}[]()"
    val input2 = "{[}]"
    val input3 = "{[{}]}"
    val input4 = ")(()"

    println(check(input1))
    println(check(input2))
    println(check(input3))
    println(check(input4))
  }
  
  def check(str: String): Boolean = {
    val stack = Stack[Char]()
    
    var result = true
    
    str.toCharArray.foreach(c => {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c)
      } else {
        if (stack.isEmpty) {
          result = false
        } else {
          if (c == ')') {
            val curr = stack.pop
            if (curr != '(') {
              result = false
            }
          } else if (c == '}') {
            val curr = stack.pop
            if (curr != '{') {
              result = false
            }
          } else if (c == ']') {
            val curr = stack.pop
            if (curr != '[') {
              result = false
            }
          }
        }
      } 
      
    })
    
    result
  }
}