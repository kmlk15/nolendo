

/**
 * @author kmlk15
 */
object HouseRobber {
  case class Node(value: Int, left: Node, right: Node)

  def main(args: Array[String]) {
    val input1 = Node(3, Node(2, null, Node(3, null, null)), Node(3, null, Node(1, null, null)))
    val input2 = Node(3, Node(4, Node(1, null, null), Node(3, null, null)), Node(5, null, Node(1, null, null)))

    println(p(input1))
    println(p(input2))

  }

  def p(n: Node): Int = {
    var a = 0
    var b = 0

    def walk(n: Node, odd: Boolean) {
      if (odd) a = a + n.value else b = b + n.value
      if (n.left != null) {
        walk(n.left, !odd)
      }
      if (n.right != null) {
        walk(n.right, !odd)
      }
    }
    
    walk(n, true)
    Math.max(a, b)
  }

}